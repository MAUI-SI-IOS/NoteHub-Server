package com.mauisiios.notehub_server.dto

import com.mauisiios.notehub_server.model.NoteFormattedExpression

data class NoteDto(
    val id: Long? = null,
    val title: String,
    val rawContent: String,
    val formattedContent: List<NoteFormattedExpression> = emptyList(),
)