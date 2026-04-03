package com.mauisiios.notehub_server.interpreter

import com.mauisiios.notehub_server.model.NoteFormattedExpression

class InterpreterContext {
    val expressions: MutableList<NoteFormattedExpression> = mutableListOf()
    var isNewLine = true
}