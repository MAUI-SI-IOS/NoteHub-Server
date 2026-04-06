package com.mauisiios.notehub_server.service.COR_BUILDER
import kotlinx.coroutines.flow.*
import opennlp.tools.postag.POSModel
import opennlp.tools.postag.POSTaggerME
import org.springframework.stereotype.Component

@Component
class TaggingHandler(
    override var next: IHandler<Flow<Pair<String, Int>>, *>? = null
) : IHandler<Flow<String>, Flow<Pair<String, Int>>>  {


    private var tagger: POSTaggerME
    init {
        val modelFile = ClassLoader.getSystemResourceAsStream("models/fr-pos.bin")
        val model = POSModel(modelFile)
        tagger = POSTaggerME(model)
    }

    override suspend fun filter(item: Flow<String>): Flow<Pair<String, Int>> {
        val tokenList = item.toList()
        val tags = tagger.tag(tokenList.toTypedArray())
            .toList()
            .asFlow()
        
        return item
            .zip(tags) { token, tag -> token to tag }
            .filter { (_, tag) ->
                // String! type assert that tag is not null
                // if the tagger failed to tag the token, 
                // we filter it out
                tag != null &&
                // Nom commun
                tag == "NOUN" ||
                // Nom propre
                tag == "PROPN" ||
                // Symbol (C#)
                tag == "SYM" ||
                // Numero
                tag == "NUM" ||
                // Ce qui n'est pas classer comme un theme valide
                tag == "X"
            }
            .scan(mutableMapOf<String, Int>()) { occurrenceMap, (token, _) ->
                occurrenceMap[token] = (occurrenceMap[token] ?: 0) + 1
                occurrenceMap
            }
            .zip(item) { occurrenceMap, token -> 
                token to occurrenceMap[token]!!
            }
    }
}