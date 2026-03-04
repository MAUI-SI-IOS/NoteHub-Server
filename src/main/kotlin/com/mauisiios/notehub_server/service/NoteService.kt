package com.mauisiios.notehub_server.service

import com.mauisiios.notehub_server.data.entity.NoteEntity
import com.mauisiios.notehub_server.data.entity.NoteTokenId
import com.mauisiios.notehub_server.data.entity.NoteTokensEntity
import com.mauisiios.notehub_server.data.entity.TokenEntity
import com.mauisiios.notehub_server.data.repo.NoteRepository
import com.mauisiios.notehub_server.data.repo.NoteTokenRepository
import com.mauisiios.notehub_server.data.repo.TokenRepository
import com.mauisiios.notehub_server.dto.NoteDto
import com.mauisiios.notehub_server.mapper.toDto
import com.mauisiios.notehub_server.mapper.toEntity
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.toSet
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class NoteService(
    private val nlpService: NLPService,
    private val noteRepository: NoteRepository,
    private val tokenRepository: TokenRepository,
    private val noteTokenRepository: NoteTokenRepository,
) {
    fun getAll(): Flow<NoteDto> = noteRepository.findAll()
        .map(NoteEntity::toDto)

    suspend fun getById(id: Long): NoteDto? = noteRepository.findById(id)
        ?.toDto()

    suspend fun getByTitle(title: String): NoteDto? = noteRepository.findByTitle(title)
        ?.toDto()

    @Transactional
    suspend fun createNote(note: NoteDto) {
        val note = noteRepository.save(note.toEntity())
        val note_id = note.id  ?: throw IllegalStateException("Couldnt find note id");

        val words = nlpService.analyze(note.rawContent)
        val keys   = words.keys

        val existingTokens = tokenRepository.findAllById(keys)
        val existingWords = existingTokens.map { it.token }.toSet()

        val newTokens = keys.filter { it !in existingWords}
            .map { TokenEntity(it) }
        tokenRepository.saveAll(newTokens).collect{}

        val noteTokens = words.map { (word, frequency)->
            NoteTokensEntity(
                NoteTokenId(note_id, word),
                frequency
            )
        }
        noteTokenRepository.saveAll(noteTokens).collect {}
    }

    suspend fun deleteNote(id: Long) = noteRepository.deleteById(id)

    suspend fun updateNote(note: NoteDto) = noteRepository.save(note.toEntity())

}