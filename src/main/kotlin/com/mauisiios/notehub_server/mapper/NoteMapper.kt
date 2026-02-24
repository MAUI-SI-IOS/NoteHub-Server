package com.mauisiios.notehub_server.mapper

import com.mauisiios.notehub_server.data.entity.Note
import com.mauisiios.notehub_server.dto.NoteDto

fun NoteDto.toEntity() = Note(
        id = this.id,
        title = this.title,
        rawContent = this.rawContent,
        formattedContent = this.formattedContent
)

fun Note.toDto() = NoteDto(
        id = this.id,
        title = this.title,
        rawContent = this.rawContent,
        formattedContent = this.formattedContent
)
