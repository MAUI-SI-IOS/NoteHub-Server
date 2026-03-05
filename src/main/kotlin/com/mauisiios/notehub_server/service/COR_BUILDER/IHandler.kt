package com.mauisiios.notehub_server.service.COR_BUILDER


interface ITokenHandler<I,O> {
    var next: ITokenHandler<O, *>?;

    fun handle(item: I): Any? {
        val item = filter(item);
        return next?.handle(item) ?: item
    }

    fun filter(item: I): O
}



