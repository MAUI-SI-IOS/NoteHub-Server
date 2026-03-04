package com.mauisiios.notehub_server.data.entity

import jakarta.persistence.Entity
import org.springframework.data.annotation.Id
import org.springframework.data.relational.core.mapping.Table

@Table("note")
data class NoteEntity(
    @Id var id: Long? = null,
    var title: String = "",
    var rawContent: String,
    var formattedContent: String,
)