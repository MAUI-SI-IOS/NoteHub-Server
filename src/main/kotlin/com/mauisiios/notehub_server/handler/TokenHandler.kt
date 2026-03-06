package com.mauisiios.notehub_server.handler

import com.mauisiios.notehub_server.service.TokenService
import kotlinx.coroutines.coroutineScope
import org.springframework.http.MediaType
import org.springframework.stereotype.Component
import org.springframework.web.reactive.function.server.ServerRequest
import org.springframework.web.reactive.function.server.ServerResponse
import org.springframework.web.reactive.function.server.ServerResponse.ok
import org.springframework.web.reactive.function.server.bodyAndAwait

@Component
class TokenHandler(
    private val tokenService: TokenService
) {

    suspend fun allNoteFromToken(req: ServerRequest): ServerResponse = coroutineScope {
        val token = req.pathVariable("token")
        val note = tokenService.getAllNoteByToken(token)

        ok()
            .contentType(MediaType.APPLICATION_JSON)
            .bodyAndAwait(note)
    }

    suspend fun allTokenFromNote(req: ServerRequest): ServerResponse = coroutineScope {
        val id = req.pathVariable("id").toLong()
        val token = tokenService.getAllTokenByNote(id)


        ok()
            .contentType(MediaType.APPLICATION_JSON)
            .bodyAndAwait(token)
    }

}