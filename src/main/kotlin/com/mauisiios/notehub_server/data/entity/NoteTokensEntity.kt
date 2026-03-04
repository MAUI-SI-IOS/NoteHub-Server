package com.mauisiios.notehub_server.data.entity

import jakarta.persistence.Column
import jakarta.persistence.Embeddable
import jakarta.persistence.Embedded
import jakarta.persistence.EmbeddedId
import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.persistence.Table



@Table(name = "note_token")
data class NoteTokensEntity (
    val noteId: Long,
    val tokenId: String,
    val frequency: Int = 1,
)