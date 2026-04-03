package com.mauisiios.notehub_server.interpreter

import com.mauisiios.notehub_server.model.NoteFormattedExpression
import com.mauisiios.notehub_server.model.NoteFormattedExpressionType

class DashCharInterpreter : IMarkdownCharInterpreter {
    override val c: Char = '-'
    override fun interpret(ctx: InterpreterContext) {
        if (ctx.isNewLine)
            ctx.expressions.add(
                NoteFormattedExpression(
                    NoteFormattedExpressionType
                        .ListItem.Unordered,
                    "",
                )
            ).run { ctx.isNewLine = false }
        else ctx.expressions.last().apply { content += c }

        ctx.isNewLine = false
    }

}