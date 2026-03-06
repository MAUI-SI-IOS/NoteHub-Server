package com.mauisiios.notehub_server.unit


import com.mauisiios.notehub_server.service.COR_BUILDER.HandlerChainBuilder
import com.mauisiios.notehub_server.service.COR_BUILDER.TaggingHandler
import com.mauisiios.notehub_server.service.COR_BUILDER.TokenizerHandler
import kotlinx.coroutines.test.runTest
import kotlin.test.Test

class ChainHandlerTest{

    private val taggingHandler: TaggingHandler = TaggingHandler()
    private val tokenizerHandler: TokenizerHandler = TokenizerHandler()



    @Test
    fun `Test tokenizer transformer`() = runTest {
        val data = "Ceci est un test C# C# 1"
        //should return [C#,test, 1]
        val chain = HandlerChainBuilder
            .start(tokenizerHandler)
            .build()

        val filtered = chain.execute(data);
        println(filtered.toString())
        org.assertj.core.api.Assertions.assertThat(filtered)
            .hasSize(7)
    }

    @Test
    fun `Test tagger transformer`() = runTest {
        val data = listOf<String>("Ceci", "est", "un", "test", "C#", "C#", "1")
        //should return [C#,test, 1]
        val chain = HandlerChainBuilder
            .start(taggingHandler)
            .build()

        val filtered = chain.execute(data);
        println(filtered.toString())
        org.assertj.core.api.Assertions.assertThat(filtered)
            .hasSize(3)
    }

    @Test
    fun `Test pipe`() = runTest {
        val data = "Ceci est un test C# C# 1"
        //should return [C#,test, 1]
        val chain = HandlerChainBuilder
                    .start(tokenizerHandler)
                    .append(taggingHandler)
                    .build()

        val filtered = chain.execute(data)
            ?: throw Exception("filter is null")

        println(filtered.toString())
        org.assertj.core.api.Assertions.assertThat(filtered)
            .hasSize(3)
            .containsEntry("C#",2)
            .containsEntry("test",1)
            .containsEntry("1",1)
            .doesNotContainKey("is")
    }
}