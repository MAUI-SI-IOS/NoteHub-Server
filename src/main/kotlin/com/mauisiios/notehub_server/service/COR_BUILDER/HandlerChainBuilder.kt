package com.mauisiios.notehub_server.service.COR_BUILDER

//For type safety
class HandlerChainBuilder<I,O>(
    var _head: IHandler<I,*>,
    var _tail: IHandler<*,O>,
)
{
    companion object {
        fun <I,O> start(first: IHandler<I,O>): HandlerChainBuilder<I,O> {
            return HandlerChainBuilder(first,first)
        }
    }

    fun <I2>prepend(first: IHandler<I2,I>): HandlerChainBuilder<I2,O>{
        first.next = _head
        return HandlerChainBuilder<I2,O>(_head=first, _tail=_tail)
    }

    fun <O2>append(last: IHandler<O,O2>): HandlerChainBuilder<I,O2>{
        _tail.next = last
        return HandlerChainBuilder<I,O2>(_head=_head, _tail = last)
    }

    fun build(): Chain<I,O> {
        return Chain(head = _head);
    }
}

class Chain<I,O>( private val head: IHandler<I,*> ){
    fun execute(item: I): O? {

        return head.handle(item) as? O
    }
}

