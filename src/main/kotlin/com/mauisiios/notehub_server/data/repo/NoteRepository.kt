package com.mauisiios.notehub_server.data.repo

import com.mauisiios.notehub_server.data.entity.NoteEntity
import org.springframework.data.r2dbc.repository.Query
import org.springframework.data.repository.kotlin.CoroutineCrudRepository

interface NoteRepository: CoroutineCrudRepository<NoteEntity, Long> {
    @Query("SELECT * FROM note WHERE title = :title")
    suspend fun findByTitle(title: String): NoteEntity?
}