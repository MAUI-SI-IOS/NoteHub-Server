package com.mauisiios.notehub_server.service.COR

import opennlp.tools.tokenize.Tokenizer;
import org.springframework.stereotype.Component

class TokenizerHandler(
    private val tokenizer: Tokenizer,
    override var next: ITokenHandler<List<String>, *>? = null
): ITokenHandler<String,List<String>> {


    override fun filter(item: String):List<String>  {
        return tokenizer.tokenize(item).toList<String>()
    }
}