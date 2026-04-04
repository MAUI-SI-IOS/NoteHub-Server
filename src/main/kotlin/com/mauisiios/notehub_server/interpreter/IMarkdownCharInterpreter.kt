package com.mauisiios.notehub_server.interpreter

interface IMarkdownCharInterpreter {
    val c: Char
    fun interpret(ctx: InterpreterContext)
}