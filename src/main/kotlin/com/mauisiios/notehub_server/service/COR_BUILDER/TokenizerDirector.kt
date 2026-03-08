package com.mauisiios.notehub_server.service.COR_BUILDER

import org.springframework.stereotype.Component

@Component
object TokenizerDirector {
    val tokenizerHandler: TokenizerHandler = TokenizerHandler()
    val taggerHandler: TaggingHandler = TaggingHandler()

    fun makeTokinizerHandlerChain() = HandlerChainBuilder
        .start(tokenizerHandler)
        .append(taggerHandler)
        .build()


}