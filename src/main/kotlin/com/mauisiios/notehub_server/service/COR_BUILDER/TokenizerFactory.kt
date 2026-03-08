package com.mauisiios.notehub_server.service.COR_BUILDER

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import org.springframework.stereotype.Component

@Component
object TokenizerFactory {
    val director: TokenizerDirector = TokenizerDirector

    suspend fun tokenize(data: String) = withContext(Dispatchers.Default) {
        director
            .makeTokinizerHandlerChain()
            .execute(data)
    }
}