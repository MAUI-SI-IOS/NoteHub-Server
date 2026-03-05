package com.mauisiios.notehub_server.service.COR_BUILDER

import jakarta.annotation.PostConstruct
import opennlp.tools.postag.POSTaggerME
import opennlp.tools.tokenize.TokenizerME
import opennlp.tools.tokenize.TokenizerModel
import org.springframework.stereotype.Component

@Component
class TokenizerHandler(
    override var next: IHandler<List<String>, *>? = null
): IHandler<String,List<String>> {

    private lateinit var tokenizer: TokenizerME
    @PostConstruct
    fun init() {
        // Loading the model from resources/models/en-pos-maxent.bin (example name)
        val modelFile = ClassLoader.getSystemResourceAsStream("models/fr-token.bin")
        val model = TokenizerModel(modelFile)
        tokenizer = TokenizerME(model)
    }


    override fun filter(item: String):List<String>  {
        return tokenizer.tokenize(item).toList<String>()
    }
}