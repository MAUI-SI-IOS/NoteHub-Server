package com.mauisiios.notehub_server.service.COR

import java.util.SortedMap;
import opennlp.tools.postag.POSTagger
import org.springframework.stereotype.Component

class TaggingHandler(
    private val tagger: POSTagger = POSTagger(),
    override var next: ITokenHandler<SortedMap<String, Int>, *>? = null
) : ITokenHandler<List<String>, SortedMap<String, Int>>  {


    override fun filter(item: List<String>): SortedMap<String, Int> {
        val tokens = item.toTypedArray()
        return this.filter(tokens)
    }

    fun filter(item: Array<String>): SortedMap<String, Int> {
        val tags = tagger.tag(item)
        return item.zip(tags)
            .filter { (_, tag) ->
                tag == "NN" || tag == "NNS" || tag == "NNP" || tag == "NNPS"
            }
            .groupingBy { (word,_) -> word }
            .eachCount()
            .toSortedMap()
    }
}