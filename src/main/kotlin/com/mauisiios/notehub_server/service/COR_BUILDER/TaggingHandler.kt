package com.mauisiios.notehub_server.service.COR_BUILDER
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
        val modelFile = ClassLoader.getSystemResourceAsStream("models/fr-pos.bin")
        val model = POSModel(modelFile)
        tagger = POSTaggerME(model)
    }

    override fun filter(item: List<String>): SortedMap<String, Int> {
        val tokens = item.toTypedArray()
        val tags = tagger.tag(tokens)
        return item.zip(tags)
            .filter { (_, tag) -> // on considere les
                tag == "NOUN" ||  // nom commun
                tag == "PROPN"||  // Nom propre
                tag == "SYM"  ||  // symbole (C#)
                tag == "NUM"  ||  // numero
                tag == "X"        // ce qui n'est pas capable de classer
            }                     // comme un theme valide
            .groupingBy { it.first }
            .eachCount()
            .toSortedMap()
    }
}