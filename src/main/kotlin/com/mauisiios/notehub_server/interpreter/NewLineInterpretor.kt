package com.mauisiios.notehub_server.interpreter

import com.mauisiios.notehub_server.model.NoteFormattedExpression
import com.mauisiios.notehub_server.model.NoteFormattedExpressionType

class NewLineInterpretor : IMarkdownCharInterpreter {
    override val c: Char = '\n'
    override fun interpret(ctx: InterpreterContext) {
        val lastExpression = ctx.expressions.lastOrNull()

        when {
            lastExpression == null  -> ctx.expressions.add(
                NoteFormattedExpression(
                    NoteFormattedExpressionType.PlainText,
                    "",
                )
            )

            lastExpression.content.endsWith(" ".repeat(2)) && lastExpression.type == NoteFormattedExpressionType.PlainText -> {
                lastExpression.content = lastExpression.content
                    .dropLast(2)
                    .plus("\n")
            }

            else -> ctx.isNewLine = true
        }
    }
}