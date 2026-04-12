package com.mauisiios.notehub_server.integration

import com.mauisiios.notehub_server.TestcontainersConfiguration
import com.mauisiios.notehub_server.dto.NoteDto
import com.mauisiios.notehub_server.dto.NoteTokenDto
import com.mauisiios.notehub_server.model.NoteFormattedExpression
import com.mauisiios.notehub_server.model.NoteFormattedExpressionType
import kotlinx.coroutines.reactive.awaitSingle
import kotlinx.coroutines.runBlocking
import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestInstance
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.webtestclient.autoconfigure.AutoConfigureWebTestClient
import org.springframework.context.annotation.Import
import org.springframework.r2dbc.core.DatabaseClient
import org.springframework.test.web.reactive.server.WebTestClient
import org.springframework.test.web.reactive.server.expectBody
import org.springframework.test.web.reactive.server.expectBodyList


@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@Import(TestcontainersConfiguration::class)
@AutoConfigureWebTestClient
@TestInstance(TestInstance.Lifecycle.PER_CLASS) //permet once()
class TestTokenRoutes(
    @Autowired val client: WebTestClient,
    @Autowired val dbClient: DatabaseClient,
) {


    @BeforeAll
    fun once(): Unit = runBlocking {
        // Now dbClient and client are fully injected and ready to use
        dbClient.sql("TRUNCATE TABLE note RESTART IDENTITY CASCADE")
            .fetch().rowsUpdated()
            .awaitSingle()

        val newNote = NoteDto(
            null,
            "Premiere Note",
            "la nouvelle note C#, bonjour au monde entier",
        )

        client.post()
            .uri("/note/")
            .bodyValue(newNote)
            .exchange()
            .expectStatus().isOk
            .expectBody<NoteDto>()
    }


    @Test
    fun `search token should should return notes`() {

        client.get()
            .uri("/token/{token}", "C#")
            .exchange()
            .expectStatus().isOk
            .expectBodyList<NoteDto>()
            .hasSize(1)
            .contains(
                NoteDto(
                    1,
                    "Premiere Note",
                    "la nouvelle note C#, bonjour au monde entier",
                    listOf(NoteFormattedExpression(NoteFormattedExpressionType.PlainText, "la nouvelle note C#, bonjour au monde entier"))
                )
            )
    }

    @Test
    fun `search note should should return tokens`() {
        client.get().uri("token/note/1") //checks tokens of note 1
            .exchange()
            .expectStatus().isOk
            .expectBodyList<NoteTokenDto>()
            .hasSize(4)

    }

}