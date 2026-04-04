package com.mauisiios.notehub_server.flyweight

import com.mauisiios.notehub_server.interpreter.*
import kotlin.reflect.KClass

object InterpreterFlyweightStore {
    private val cache = mutableMapOf<KClass<out IMarkdownCharInterpreter>, IMarkdownCharInterpreter>()

    fun getInterpreter(k: Char): IMarkdownCharInterpreter {
        val type = getType(k)
    return if (cache.containsKey(type))
        cache[type]!!.apply {
            if (this is LetterInterpreter)
                character = k
        }
    else {

            val interpreter: IMarkdownCharInterpreter = when (type) {
                ClosingParantheseInterpreter::class -> ClosingParantheseInterpreter()
                NewLineInterpretor::class -> NewLineInterpretor()
                SpaceCharInterpreter::class -> SpaceCharInterpreter()
                else -> {
                    LetterInterpreter(k)
                }
            }
            cache[type] = interpreter

            interpreter
        }
    }

    fun getType(key: Char): KClass<out IMarkdownCharInterpreter> = when (key) {
            ')' -> ClosingParantheseInterpreter::class
            '\n', '\r' -> NewLineInterpretor::class
            ' ' -> SpaceCharInterpreter::class
            else -> LetterInterpreter::class
        }
}