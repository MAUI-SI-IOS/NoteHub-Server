package com.mauisiios.notehub_server.mapper

import com.mauisiios.notehub_server.data.entity.NoteEntity
import com.mauisiios.notehub_server.dto.NoteDto
import com.mauisiios.notehub_server.dto.ws.UpdateNoteSyncAction

fun NoteDto.toEntity() = NoteEntity(
        id = this.id,
        title = this.title,
        rawContent = this.rawContent,
        formattedContent = this.formattedContent,
)

fun NoteEntity.toDto() = NoteDto(
        id = this.id,
        title = this.title,
        rawContent = this.rawContent,
        formattedContent = this.formattedContent,
)

fun UpdateNoteSyncAction.toDto() = NoteDto(
        id = this.id,
        title = this.title,
        rawContent = this.content,
)