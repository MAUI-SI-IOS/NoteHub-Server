package com.mauisiios.notehub_server.interpreter

import com.mauisiios.notehub_server.model.NoteFormattedExpression

class InterpreterContext {
    internal val expressions: MutableList<NoteFormattedExpression> = mutableListOf()
    internal var isNewLine = true

    val interpretedExpressions: List<NoteFormattedExpression>
        get() = expressions
}