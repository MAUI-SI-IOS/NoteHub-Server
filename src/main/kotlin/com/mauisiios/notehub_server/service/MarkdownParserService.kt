package com.mauisiios.notehub_server.service

import com.mauisiios.notehub_server.flyweight.InterpreterFlyweightStore
import com.mauisiios.notehub_server.interpreter.InterpreterContext
import com.mauisiios.notehub_server.model.NoteFormattedExpression
import kotlinx.coroutines.flow.asFlow
import org.springframework.stereotype.Service

@Service
class MarkdownParserService {

    suspend fun parse(markdown: String): List<NoteFormattedExpression> {
        val mdFlow = markdown
            .toList()
            .asFlow()

        val interpreterCtx = InterpreterContext()

        mdFlow.collect { character ->
            InterpreterFlyweightStore
                .getInterpreter(character)
                .interpret(interpreterCtx)
        }

        return interpreterCtx.expressions
    }

}