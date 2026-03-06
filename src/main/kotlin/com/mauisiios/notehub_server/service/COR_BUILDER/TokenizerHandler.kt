package com.mauisiios.notehub_server.service.COR_BUILDER

import opennlp.tools.tokenize.TokenizerME
import opennlp.tools.tokenize.TokenizerModel
import org.springframework.stereotype.Component

@Component
class TokenizerHandler(
    override var next: IHandler<List<String>, *>? = null
): IHandler<String,List<String>> {


    private var tokenizer: TokenizerME
    init {
        val modelFile = ClassLoader.getSystemResourceAsStream("models/fr-token.bin")
        val model = TokenizerModel(modelFile)
        tokenizer = TokenizerME(model)
    }


    override fun filter(item: String):List<String>  {
        return tokenizer.tokenize(item).toList<String>()
    }
}