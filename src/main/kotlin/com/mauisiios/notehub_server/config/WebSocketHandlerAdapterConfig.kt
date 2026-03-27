package com.mauisiios.notehub_server.config

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.web.reactive.socket.server.support.WebSocketHandlerAdapter

@Configuration(proxyBeanMethods = false)
class WebSocketHandlerAdapterConfig {

    @Bean
    fun handlerAdapter() = WebSocketHandlerAdapter()
}