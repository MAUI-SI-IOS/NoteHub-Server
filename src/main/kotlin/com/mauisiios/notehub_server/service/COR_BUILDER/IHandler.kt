package com.mauisiios.notehub_server.service.COR_BUILDER


interface IHandler<I,O> {
    var next: IHandler<O, *>?;

    fun handle(item: I): Any? {
        val item = filter(item);
        return next?.handle(item) ?: item
    }

    fun filter(item: I): O
}



