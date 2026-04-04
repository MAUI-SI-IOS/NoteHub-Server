package com.mauisiios.notehub_server.interpreter

import com.mauisiios.notehub_server.model.NoteFormattedExpression
import com.mauisiios.notehub_server.model.NoteFormattedExpressionType

class SpaceCharInterpreter : IMarkdownCharInterpreter {
    override val c: Char = ' '
    override fun interpret(ctx: InterpreterContext) {
        val lastExpression = ctx.expressions.lastOrNull()

        when {
            lastExpression == null -> ctx.expressions.add(
                NoteFormattedExpression(
                    NoteFormattedExpressionType.PlainText,
                    c.toString(),
                )
            )

            ctx.isNewLine -> {
                ctx.expressions.add(
                    NoteFormattedExpression(
                        NoteFormattedExpressionType.PlainText,
                        c.toString(),
                    )
                )
                ctx.isNewLine = false
            }

            lastExpression.content == " " && lastExpression.type == NoteFormattedExpressionType.PlainText -> {
                ctx.expressions.removeLast()

                val lastAfterRemoval = ctx.expressions.last()
                lastAfterRemoval.content += "\n"
            }


            lastExpression.content.all { it == '#' } && lastExpression.type == NoteFormattedExpressionType.PlainText -> {
                ctx.expressions.removeLast()

                val headerLevel = lastExpression.content.length
                ctx.expressions.add(
                    NoteFormattedExpression(
                        NoteFormattedExpressionType.Header(headerLevel),
                        ""
                    )
                )
            }

            lastExpression.content in listOf("*", "-", "+") && lastExpression.type == NoteFormattedExpressionType.PlainText -> {
                ctx.expressions.removeLast()

                ctx.expressions.add(
                    NoteFormattedExpression(
                        NoteFormattedExpressionType.ListItem.Unordered,
                        ""
                    )
                )
            }

            "^\\d+\\.$".toRegex().matches(lastExpression.content) && lastExpression.type == NoteFormattedExpressionType.PlainText -> {
                ctx.expressions.removeLast()

                ctx.expressions.add(
                    NoteFormattedExpression(
                        NoteFormattedExpressionType.ListItem.Ordered,
                        ""
                    )
                )
            }

            "^\\[([ x])]$".toRegex().matches(lastExpression.content) && lastExpression.type == NoteFormattedExpressionType.ListItem.Unordered -> {
                ctx.expressions.removeLast()

                ctx.expressions.add(
                    NoteFormattedExpression(
                        NoteFormattedExpressionType.ListItem.CheckBox(
                            lastExpression.content
                                .take(3)
                                .contains("x")
                        ),
                        ""
                    )
                )
            }





            else -> {
                lastExpression.content += c
            }
        }
    }

}