package com.mauisiios.notehub_server.service.COR_BUILDER

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.asFlow
import opennlp.tools.tokenize.TokenizerME
import opennlp.tools.tokenize.TokenizerModel
import org.springframework.stereotype.Component

@Component
class TokenizerHandler(
    override var next: IHandler<Flow<String>, *>? = null
): IHandler<String, Flow<String>> {


    private var tokenizer: TokenizerME
    init {
        val modelFile = ClassLoader.getSystemResourceAsStream("models/fr-token.bin")
        val model = TokenizerModel(modelFile)
        tokenizer = TokenizerME(model)
    }


    override suspend fun filter(item: String): Flow<String>  {
        return tokenizer.tokenize(item)
            .asFlow()
    }
}