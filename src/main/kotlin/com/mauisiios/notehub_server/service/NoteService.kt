package com.mauisiios.notehub_server.service

import com.mauisiios.notehub_server.data.entity.NoteEntity
import com.mauisiios.notehub_server.data.entity.NoteTokensEntity
import com.mauisiios.notehub_server.data.repo.NoteRepository
import com.mauisiios.notehub_server.data.repo.NoteTokenRepository
import com.mauisiios.notehub_server.data.repo.TokenRepository
import com.mauisiios.notehub_server.dto.NoteDto
import com.mauisiios.notehub_server.mapper.toDto
import com.mauisiios.notehub_server.mapper.toEntity
import com.mauisiios.notehub_server.service.COR_BUILDER.HandlerChainBuilder
import com.mauisiios.notehub_server.service.COR_BUILDER.TaggingHandler
import com.mauisiios.notehub_server.service.COR_BUILDER.TokenizerHandler
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import org.springframework.stereotype.Service

@Service
class NoteService(
    private val noteRepository: NoteRepository,
    private val taggerHandler: TaggingHandler,
    private val tokenizerHandler: TokenizerHandler,
    private val tokenRepository: TokenRepository,
    private val noteTokenRepository: NoteTokenRepository
) {
    fun getAll(): Flow<NoteDto> = noteRepository.findAll()
        .map(NoteEntity::toDto)

    suspend fun getById(id: Long): NoteDto? = noteRepository.findById(id)
        ?.toDto()

    suspend fun getByTitle(title: String): NoteDto? = noteRepository.findByTitle(title)
        ?.toDto()

    suspend fun createNote(note: NoteDto): NoteDto{

        val savedEntity = noteRepository.save(note.toEntity())
        val resultDto = savedEntity.toDto()
        val noteId = resultDto.id ?: throw IllegalStateException("Note ID was not generated")


        //process tokens
        val processedTokens = HandlerChainBuilder
            .start(tokenizerHandler)
            .append(taggerHandler)
            .build()

            .execute(note.rawContent)
            ?.map { NoteTokensEntity(noteId , it.key, it.value) }
            ?: throw Exception("no tokens???"); //TODO a modifier si il a lieux


        tokenRepository.saveAllUnique(processedTokens.map {it.tokenId}.toTypedArray())


        noteTokenRepository.saveAll(processedTokens).collect {}

        return resultDto

    }

    suspend fun deleteNote(id: Long) = noteRepository.deleteById(id)

    suspend fun updateNote(note: NoteDto) = noteRepository.save(note.toEntity())

}