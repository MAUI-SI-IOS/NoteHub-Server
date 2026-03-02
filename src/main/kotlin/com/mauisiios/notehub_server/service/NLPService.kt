package com.mauisiios.notehub_server.service

import jakarta.annotation.PostConstruct
import opennlp.tools.postag.POSModel
import opennlp.tools.postag.POSTaggerME
import opennlp.tools.tokenize.TokenizerME
import opennlp.tools.tokenize.TokenizerModel
import org.springframework.stereotype.Service
import java.io.IOException
import java.util.SortedMap

@Service
class NLPService {

    private lateinit var tokenizer: TokenizerME
    private lateinit var posTagger: POSTaggerME

    @PostConstruct
    @Throws(IOException::class)
    fun init() {
        javaClass.getResourceAsStream("/models/fr-token.bin")?.use { modelIn ->
            val model = TokenizerModel(modelIn)
            this.tokenizer = TokenizerME(model)
        } ?: throw IOException("Modèle fr-token.bin introuvable")

        javaClass.getResourceAsStream("/models/fr-pos.bin")?.use { modelIn ->
            val model = POSModel(modelIn)
            this.posTagger = POSTaggerME(model)
        } ?: throw IOException("Modèle fr-pos-maxent.bin introuvable")
    }

    fun analyze(text: String): SortedMap<String, Int> {
        var skipList: SortedMap<String, Int> = sortedMapOf();

        val tokens = tokenizer.tokenize(text)
        val tags = posTagger.tag(tokens)

        tokens.zip(tags)
              .filter{(_, tag)-> tag == "NC" || tag == "NPP" || tag == "NOUN" || tag == "PROPN" }
              .forEach{
                  (token,_)-> skipList[token] = (skipList[token]?: 0) + 1
              }
        return skipList
    }
}

