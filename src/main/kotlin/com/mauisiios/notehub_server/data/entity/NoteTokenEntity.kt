package com.mauisiios.notehub_server.data.entity


import org.springframework.data.domain.Persistable
import org.springframework.data.relational.core.mapping.Table


@Table("note_token")
data class NoteTokenEntity (
    val noteId: Long,
    val token: String,
    val frequency: Int = 1,
)