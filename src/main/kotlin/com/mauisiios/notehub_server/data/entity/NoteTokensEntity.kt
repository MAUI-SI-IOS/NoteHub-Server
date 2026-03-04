package com.mauisiios.notehub_server.data.entity

import jakarta.persistence.Column
import jakarta.persistence.Embeddable
import jakarta.persistence.Embedded
import jakarta.persistence.EmbeddedId
import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.persistence.Table

@Embeddable
data class NoteTokenId(
    val note_id: Long,
    val token: String
)

@Table(name = "note_token")
data class NoteTokensEntity (
    @EmbeddedId
    var id: NoteTokenId,
    @Column
    var frequency: Int = 1,
)