
package com.mauisiios.notehub_server.integration


import com.mauisiios.notehub_server.TestcontainersConfiguration
import com.mauisiios.notehub_server.dto.NoteDto
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

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@Import(TestcontainersConfiguration::class)
@AutoConfigureWebTestClient
class TestNoteRoutes(
    @Autowired val client: WebTestClient,
    @Autowired val dbClient: DatabaseClient,
    @Autowired val rescLoader: ResourceLoader
){

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
    fun `should return all notes`() {
        client.get()
            .uri("/note/")
            .exchange()
            .expectStatus().isOk
            .expectBodyList(NoteDto::class.java)
            .hasSize(10)
    }

    @Test
    fun `should return a single note`() {
        client.get()
            .uri("/note/1")
            .exchange()
            .expectStatus().isOk
            .expectBody<NoteDto>()
            .consumeWith { result ->
                val body = result.responseBody!!
                assert(body.title == "First Note")
                assert(body.formattedContent.isNotEmpty())
            }
    }

    @Test
    fun `should return a single note by title`() {
        client.get()
            .uri("/note/title/First Note")
            .exchange()
            .expectStatus().isOk
            .expectBody<NoteDto>()
            .consumeWith { result ->
                val body = result.responseBody!!
                assert(body.title == "First Note")
                assert(body.formattedContent.isNotEmpty())
            }
    }

    @Test
    fun `should create a new note`() {
        val newNote = NoteDto(
            null,
            "New Note",
            "Content for the new note",
            emptyList()
        )
        client.post()
            .uri("/note/")
            .contentType(MediaType.APPLICATION_JSON)
            .accept(MediaType.APPLICATION_JSON)
            .bodyValue(newNote)
            .exchange()
            .expectStatus().isOk
            .expectBody<NoteDto>()
            .consumeWith { result ->
                val body = result.responseBody!!
                assert(body.title == newNote.title)
                assert(body.rawContent == newNote.rawContent)
                assert(body.formattedContent.isNotEmpty())
                // Ensure no links are created for a note with unique content (if it's the first time)
                // Actually, createNote might find tokens that exist in the seeded notes.
            }
    }

    @Test
    fun `should update a note`() {
        val updatedNote = NoteDto(
            1,
            "Updated Title",
            "Updated Raw Content",
        )
        client.patch()
            .uri("/note/")
            .bodyValue(updatedNote)
            .exchange()
            .expectStatus().isOk
            .expectBody<NoteDto>()
            .consumeWith { result ->
                val body = result.responseBody!!
                assert(body.title == updatedNote.title)
                assert(body.rawContent == updatedNote.rawContent)
                assert(body.formattedContent.isNotEmpty())
            }
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