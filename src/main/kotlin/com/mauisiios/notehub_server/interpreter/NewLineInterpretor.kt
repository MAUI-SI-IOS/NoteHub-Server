package com.mauisiios.notehub_server.interpreter

import com.mauisiios.notehub_server.model.NoteFormattedExpression
import com.mauisiios.notehub_server.model.NoteFormattedExpressionType

class NewLineInterpretor : IMarkdownCharInterpreter {
    override val c: Char = '\n'
    override fun interpret(ctx: InterpreterContext) {
        val lastExpression = ctx.expressions.lastOrNull()

        if (lastExpression == null && ctx.isNewLine) {
            ctx.expressions.add(
                NoteFormattedExpression(
                    NoteFormattedExpressionType.PlainText,
                    "",
                )
            )
        }

        ctx.isNewLine = true
    }
}