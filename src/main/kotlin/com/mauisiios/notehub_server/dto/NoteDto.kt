package com.mauisiios.notehub_server.dto

data class NoteDto(
    val id: Long? = null,
    val title: String,
    val rawContent: String,
    val formattedContent: String = "",
)