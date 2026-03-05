package com.mauisiios.notehub_server.integration

import com.mauisiios.notehub_server.DataInitializer
import com.mauisiios.notehub_server.TestcontainersConfiguration
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.DefaultApplicationArguments
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.webtestclient.autoconfigure.AutoConfigureWebTestClient
import org.springframework.context.annotation.Import
import org.springframework.r2dbc.core.DatabaseClient
import org.springframework.test.web.reactive.server.WebTestClient


@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@Import(TestcontainersConfiguration::class)
@AutoConfigureWebTestClient
class TestTokenRoutes(
    @Autowired val client: WebTestClient,
    @Autowired val dbClient: DatabaseClient,
    @Autowired val dataInitializer: DataInitializer,
) {
    @BeforeEach
    fun seed() {
        // clean database
        dbClient.sql("TRUNCATE TABLE note RESTART IDENTITY CASCADE")
            .fetch().rowsUpdated().block()

        dataInitializer.run(DefaultApplicationArguments())
    }

    @Test
    fun `search token should should return notes`() {
        client.get().uri("/token/1")//check note that contains 1


    }

    @Test
    fun `search note should should return tokens`() {
        client.get().uri("/note/1") //checks tokens of note 1

    }


}