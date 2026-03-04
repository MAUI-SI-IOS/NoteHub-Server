package com.mauisiios.notehub_server

import com.mauisiios.notehub_server.handler.NoteHandler
import com.mauisiios.notehub_server.handler.TokenHandler
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.http.MediaType
import org.springframework.web.reactive.function.server.RouterFunction
import org.springframework.web.reactive.function.server.ServerResponse
import org.springframework.web.reactive.function.server.coRouter

@Configuration(proxyBeanMethods = false)
class NoteHubRouter {

    @Bean
    fun notesRoutes(
        noteHandler: NoteHandler,
        tokenHandler: TokenHandler
    ): RouterFunction<ServerResponse> = coRouter {
        "/note".nest {
            GET("/title/{title}", noteHandler::getNoteByTitle)
            "/{id}".nest {
                GET("", noteHandler::getNote)
                DELETE("", noteHandler::deleteNote)
            }
            accept(MediaType.APPLICATION_JSON).nest {
                POST("", noteHandler::createNote)
                PATCH("", noteHandler::updateNote)
            }
            GET("", noteHandler::listNotes)
        }
        "/token".nest {
            GET("/word/{token}", tokenHandler::allNoteFromToken)
            GET("/note/{id}", tokenHandler::allTokenFromNote)
        }
    }
}