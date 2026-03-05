package com.mauisiios.notehub_server.service.COR_BUILDER
import jakarta.annotation.PostConstruct
import opennlp.tools.postag.POSModel
import java.util.SortedMap;
import opennlp.tools.postag.POSTaggerME
import org.springframework.stereotype.Component

@Component
class TaggingHandler(
    override var next: IHandler<SortedMap<String, Int>, *>? = null
) : IHandler<List<String>, SortedMap<String, Int>>  {


    private var tagger: POSTaggerME
    init {
        // Loading the model from resources/models/en-pos-maxent.bin (example name)
        val modelFile = ClassLoader.getSystemResourceAsStream("models/fr-pos.bin")
        val model = POSModel(modelFile)
        tagger = POSTaggerME(model)
    }

    override fun filter(item: List<String>): SortedMap<String, Int> {
        val tokens = item.toTypedArray()
        val tags = tagger.tag(tokens)
        return item.zip(tags)
            .filter { (_, tag) ->
                tag == "NN" || tag == "NNS" || tag == "NNP" || tag == "NNPS"
            }
            .groupingBy { (word,_) -> word }
            .eachCount()
            .toSortedMap()
    }
}