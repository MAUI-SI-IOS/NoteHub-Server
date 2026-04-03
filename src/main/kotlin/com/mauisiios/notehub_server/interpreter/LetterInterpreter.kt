package com.mauisiios.notehub_server.interpreter

import com.mauisiios.notehub_server.model.NoteFormattedExpression
import com.mauisiios.notehub_server.model.NoteFormattedExpressionType


class LetterInterpreter(
    var character: Char
) : IMarkdownCharInterpreter {
    override val c: Char
        get() = character

    override fun interpret(ctx: InterpreterContext) {
        if (ctx.isNewLine)
            ctx.expressions.add(
                NoteFormattedExpression(
                    NoteFormattedExpressionType.PlainText,
                    c.toString(),
                )
            ).run { ctx.isNewLine = false }
        else ctx.expressions
            .last()
            .apply { content += c }
    }
}