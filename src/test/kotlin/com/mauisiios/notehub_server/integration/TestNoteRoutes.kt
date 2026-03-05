package com.mauisiios.notehub_server.integration

import com.mauisiios.notehub_server.TestcontainersConfiguration
import com.mauisiios.notehub_server.dto.NoteDto
import kotlinx.coroutines.reactor.awaitSingle
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.webtestclient.autoconfigure.AutoConfigureWebTestClient
import org.springframework.context.annotation.Import
import org.springframework.core.io.ResourceLoader
import org.springframework.http.MediaType
import org.springframework.r2dbc.core.DatabaseClient
import org.springframework.test.web.reactive.server.WebTestClient
import org.springframework.test.web.reactive.server.expectBody
import org.springframework.test.web.reactive.server.expectBodyList

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@Import(TestcontainersConfiguration::class)
@AutoConfigureWebTestClient
class TestNoteRoutes(
    @Autowired val client: WebTestClient,
    @Autowired val dbClient: DatabaseClient,
    @Autowired val rescLoader: ResourceLoader
) {

    @BeforeEach
    fun seed() {
        // clean database
        dbClient.sql("TRUNCATE TABLE note RESTART IDENTITY CASCADE")
            .fetch().rowsUpdated().block()

      /*
        println("--- DATABASE TABLES ---")
        dbClient.sql("SELECT table_name FROM information_schema.tables WHERE table_schema = 'public'")
            .fetch()
            .all()
            .doOnNext { row -> println("Table found: ${row["table_name"]}") }
            .collectList()
            .block()

        println("----------------------")
      */
        val testDataResource = rescLoader.getResource("classpath:test-data.sql")
        val sql = testDataResource.inputStream.readBytes()
            .toString(Charsets.UTF_8)

        dbClient.sql(sql)
            .fetch()
            .rowsUpdated()
            .block()
    }

    @Test
    fun `should return all notes`() {
        client.get()
            .uri("/note/")
            .exchange()
            .expectStatus().isOk
            .expectBodyList<NoteDto>()
            .hasSize(10)
            .contains(
                NoteDto(
                    1,
                    "First Note",
                    "Content for the first note",
                    "Formatted content for the first note"
                )
            )
    }

    @Test
    fun `should return a single note`() {
        client.get()
            .uri("/note/1")
            .exchange()
            .expectStatus().isOk
            .expectBody<NoteDto>()
            .isEqualTo(
                NoteDto(
                    1,
                    "First Note",
                    "Content for the first note",
                    "Formatted content for the first note"
                )
            )
    }

    @Test
    fun `should return a single note by title`() {
        client.get()
            .uri("/note/title/First Note")
            .exchange()
            .expectStatus().isOk
            .expectBody<NoteDto>()
            .isEqualTo(
                NoteDto(
                    1,
                    "First Note",
                    "Content for the first note",
                    "Formatted content for the first note"
                )
            )
    }

    @Test
    fun `should create a new note`() {
        val newNote = NoteDto(
            null,
            "New Note",
            "Content for the new note",
            "Formatted content for the new note"
        )
        client.post()
            .uri("/note/")
            .bodyValue(newNote)
            .exchange()
            .expectStatus().isOk
            .expectBody<NoteDto>()
            .isEqualTo(newNote.copy(id = 11))
    }

    @Test
    fun `should update a note`() {
        val updatedNote = NoteDto(
            1,
            "Updated Title",
            "Updated Raw Content",
            "Updated Formatted Content"
        )
        client.patch()
            .uri("/note/")
            .bodyValue(updatedNote)
            .exchange()
            .expectStatus().isOk
            .expectBody<NoteDto>()
            .isEqualTo(updatedNote)
    }

    @Test
    fun `should delete a note`() {
        client.delete()
            .uri("/note/1")
            .exchange()
            .expectStatus().isNoContent

        client.get()
            .uri("/note/1")
            .exchange()
            .expectStatus().isNotFound
    }
}