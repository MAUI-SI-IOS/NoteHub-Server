package com.mauisiios.notehub_server.service

import com.mauisiios.notehub_server.data.entity.Note
import com.mauisiios.notehub_server.data.repo.NoteRepository
import com.mauisiios.notehub_server.dto.NoteDto
import com.mauisiios.notehub_server.mapper.toDto
import com.mauisiios.notehub_server.mapper.toEntity
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import org.springframework.stereotype.Service

@Service
class NoteService(
    private val noteRepository: NoteRepository
) {
    fun getAll(): Flow<NoteDto> = noteRepository.findAll()
        .map(Note::toDto)

    suspend fun getById(id: Long): NoteDto? = noteRepository.findById(id)
        ?.toDto()

    suspend fun getByTitle(title: String): NoteDto? = noteRepository.findByTitle(title)
        ?.toDto()

    suspend fun createNote(note: NoteDto) = noteRepository.save(note.toEntity())

    suspend fun deleteNote(id: Long) = noteRepository.deleteById(id)

    suspend fun updateNote(note: NoteDto) = noteRepository.save(note.toEntity())

}