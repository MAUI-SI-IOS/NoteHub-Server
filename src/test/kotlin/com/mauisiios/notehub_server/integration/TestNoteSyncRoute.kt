package com.mauisiios.notehub_server.integration

import com.mauisiios.notehub_server.TestcontainersConfiguration
import com.mauisiios.notehub_server.dto.NoteDto
import com.mauisiios.notehub_server.dto.ws.UpdateNoteSyncAction
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.web.server.LocalServerPort
import org.springframework.context.annotation.Import
import org.springframework.core.io.ResourceLoader
import org.springframework.r2dbc.core.DatabaseClient
import org.springframework.web.reactive.socket.WebSocketMessage
import org.springframework.web.reactive.socket.client.ReactorNettyWebSocketClient
import reactor.core.publisher.Mono
import tools.jackson.databind.ObjectMapper
import java.net.URI
import java.time.Duration

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@Import(TestcontainersConfiguration::class)
class TestNoteSyncRoute(
    @Autowired val dbClient: DatabaseClient,
    @Autowired val rescLoader: ResourceLoader,
    @Autowired val objectMapper: ObjectMapper
) {

    @LocalServerPort
    var port: Int = 0

    @BeforeEach
    fun seed() {
        // clean database
        dbClient.sql("TRUNCATE TABLE note RESTART IDENTITY CASCADE")
            .fetch().rowsUpdated().block()

        val testDataResource = rescLoader.getResource("classpath:test-data.sql")
        val sql = testDataResource.inputStream.readBytes()
            .toString(Charsets.UTF_8)

        dbClient.sql(sql)
            .fetch()
            .rowsUpdated()
            .block()
    }

    @Test
    fun `should update note via websocket`() {
        val client = ReactorNettyWebSocketClient()
        val updateAction = UpdateNoteSyncAction(
            id = 1,
            title = "WS Updated Title",
            content = "WS Updated Content"
        )
        val payload = objectMapper.writeValueAsString(updateAction)

        client.execute(URI.create("ws://localhost:$port/note/edit/ws")) { session ->
            val message = session.textMessage(payload)
            session.send(Mono.just(message))
                .thenMany(session.receive().take(1))
                .map { obj: WebSocketMessage -> obj.payloadAsText }
                .doOnNext { response ->
                    val noteDto = objectMapper.readValue(response, NoteDto::class.java)
                    assertEquals(1, noteDto.id)
                    assertEquals("WS Updated Title", noteDto.title)
                    assertEquals("WS Updated Content", noteDto.rawContent)
                }
                .then()
        }.block(Duration.ofSeconds(5))
    }
}
