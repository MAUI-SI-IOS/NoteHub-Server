package com.mauisiios.notehub_server.mapper

import com.mauisiios.notehub_server.data.entity.NoteTokenEntity
import com.mauisiios.notehub_server.dto.NoteTokenDto


fun NoteTokenEntity.toDto() = NoteTokenDto (
    noteId = this.noteId,
    token = this.token,
    frequency = this.frequency,
)


fun NoteTokenDto.toDto() = NoteTokenEntity (
    noteId = this.noteId,
    token = this.token,
    frequency = this.frequency,
)