package com.mauisiios.notehub_server.dto

data class NoteTokenDto(
    val noteId: Long,
    val token: String,
    val frequency: Int = 1,
)