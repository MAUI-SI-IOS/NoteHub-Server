package com.mauisiios.notehub_server.service.COR_BUILDER
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.toList
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

    override suspend fun filter(item: Flow<String>): Flow<Pair<String, Int>> = flow {
        val tokenList = item.toList()
        val tags = tagger.tag(tokenList.toTypedArray())
        
        val tokenOccurenceMap = tokenList
            .filterIndexed { index, _ ->
                val tag = tags[index]
                tag in listOf(
                    // Nom commun
                    "NOUN",
                    // Nom propre
                    "PROPN",
                    // Symbol (C#)
                    "SYM",
                    // Numero
                    "NUM",
                    // Ce qui n'est pas classer comme un theme valide
                    "X",
                )
            }
            .fold(mutableMapOf<String, Int>()) { occurrenceMap, token ->
                occurrenceMap[token] = (occurrenceMap[token] ?: 0) + 1
                occurrenceMap
            }
        
        for ((token, occurrence) in tokenOccurenceMap)
            emit(
                token to occurrence
            )
        
    }
}