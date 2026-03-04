package com.mauisiios.notehub_server.handler

import org.springframework.stereotype.Component
import org.springframework.web.reactive.function.server.ServerRequest
import org.springframework.web.reactive.function.server.ServerResponse
import reactor.core.publisher.Mono


@Component
class TokenHandler {


    fun fetchToken(request: ServerRequest): Mono<ServerResponse> {
        val token = request.pathVariable("token")

    }

}