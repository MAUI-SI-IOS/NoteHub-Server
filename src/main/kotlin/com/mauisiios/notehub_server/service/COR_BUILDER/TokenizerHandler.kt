package com.mauisiios.notehub_server.service.COR_BUILDER

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.asFlow
import opennlp.tools.tokenize.TokenizerME
import opennlp.tools.tokenize.TokenizerModel
import org.springframework.stereotype.Component
import java.io.InputStream

@Component
class TokenizerHandler(
    override var next: IHandler<Flow<String>, *>? = null
): IHandler<String, Flow<String>> {


    private var tokenizer: TokenizerME
    init {
      val resourcePath = "models/fr-token.bin" // Verify this filename!
    val inputStream = this::class.java.classLoader.getResourceAsStream(resourcePath)
        ?: throw IllegalStateException("Tokenizer model '$resourcePath' not found!")

    inputStream.use { stream ->
        val model = TokenizerModel(stream)
        tokenizer = TokenizerME(model)
    }
    }


    override suspend fun filter(item: String): Flow<String>  {
        return tokenizer.tokenize(item)
            .asFlow()
    }
}