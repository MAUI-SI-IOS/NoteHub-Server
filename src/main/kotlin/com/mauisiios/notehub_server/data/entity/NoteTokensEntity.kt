package com.mauisiios.notehub_server.data.entity


import org.springframework.data.domain.Persistable
import org.springframework.data.relational.core.mapping.Table


@Table("note_token")
data class NoteTokensEntity (
    val noteId: Long,
    val tokenId: String,
    val frequency: Int = 1,
): Persistable<String> { // Using String or a custom Class as the ID type

    override fun getId(): String = "$noteId-$tokenId"
    override fun isNew(): Boolean = true // Always INSERT
}