package com.mauisiios.notehub_server.service.COR_BUILDER
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.toList
import opennlp.tools.postag.POSModel
import opennlp.tools.postag.POSTaggerME
import org.springframework.stereotype.Component
import org.springframework.core.io.ClassPathResource
import org.springframework.core.io.ResourceLoader

@Component
class TaggingHandler(
    override var next: IHandler<Flow<Pair<String, Int>>, *>? = null
) : IHandler<Flow<String>, Flow<Pair<String, Int>>>  {


    private var tagger: POSTaggerME
    init {
	val resourcePath = "models/fr-pos.bin"
    	val inputStream = this::class.java.classLoader.getResourceAsStream(resourcePath)
        	?: throw IllegalStateException("Resource not found: $resourcePath. Ensure it is in src/main/resources/models/")

    	inputStream.use { 
        	val model = POSModel(it)
        	tagger = POSTaggerME(model)
    	}
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