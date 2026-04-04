package com.mauisiios.notehub_server.interpreter

import com.mauisiios.notehub_server.model.NoteFormattedExpression
import com.mauisiios.notehub_server.model.NoteFormattedExpressionType

class ClosingParantheseInterpreter : IMarkdownCharInterpreter {
    override val c: Char = ')'
    override fun interpret(ctx: InterpreterContext) {
        val lastExpression = ctx.expressions.lastOrNull()

        when {
            lastExpression == null -> ctx.expressions.add(
                NoteFormattedExpression(
                    NoteFormattedExpressionType.PlainText,
                    c.toString(),
                )
            )

            "\\[.*]\\(.*".toRegex().matches(lastExpression.content) -> {
                val linkStr = lastExpression.content
                    .dropWhile { it != '[' }

                val linkContent = linkStr
                    .drop(1)
                    .takeWhile { it != ']' }

                val linkUrl = linkStr
                    .dropWhile { it != '(' }
                    .drop(1)

                lastExpression.content = lastExpression.content.removeSuffix(linkStr)

                ctx.expressions.add(
                    NoteFormattedExpression(
                        NoteFormattedExpressionType
                            .Link(linkUrl),
                        linkContent
                    )
                )
            }

            else -> {
                lastExpression.content += c
            }
        }
    }

}