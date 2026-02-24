package com.mauisiios.notehub_server.data.entity

import org.springframework.data.annotation.Id

data class Note(
    @Id public var id: Long? = null,
    public var title: String = "",
    public var rawContent: String,
    public var formattedContent: String
)