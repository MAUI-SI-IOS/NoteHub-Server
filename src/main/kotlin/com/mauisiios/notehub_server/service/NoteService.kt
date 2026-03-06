package com.mauisiios.notehub_server.service

import com.mauisiios.notehub_server.data.entity.NoteEntity
import com.mauisiios.notehub_server.data.entity.NoteTokenEntity
import com.mauisiios.notehub_server.data.repo.NoteRepository
import com.mauisiios.notehub_server.data.repo.NoteTokenRepository
import com.mauisiios.notehub_server.dto.NoteDto
import com.mauisiios.notehub_server.mapper.toDto
import com.mauisiios.notehub_server.mapper.toEntity
import com.mauisiios.notehub_server.service.COR_BUILDER.HandlerChainBuilder
import com.mauisiios.notehub_server.service.COR_BUILDER.TaggingHandler
import com.mauisiios.notehub_server.service.COR_BUILDER.TokenizerHandler
import kotlinx.coroutines.*
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import org.springframework.stereotype.Service

@Service
class NoteService(
    private val noteRepository: NoteRepository,
    private val taggerHandler: TaggingHandler,
    private val tokenizerHandler: TokenizerHandler,
    private val noteTokenRepository: NoteTokenRepository
) {
    fun getAll(): Flow<NoteDto> = noteRepository.findAll()
        .map(NoteEntity::toDto)

    suspend fun getById(id: Long): NoteDto? = noteRepository.findById(id)
        ?.toDto()

    suspend fun getByTitle(title: String): NoteDto? = noteRepository.findByTitle(title)
        ?.toDto()

    suspend fun createNote(note: NoteDto): NoteDto = withContext(Dispatchers.IO) { // Optimise les routines pour les requete reseau/db
        val savedNoteDtoJob = async {
            noteRepository.save(note.toEntity())
                .toDto()
        }

        val tokenProcessingJob = async {
            HandlerChainBuilder
                .start(tokenizerHandler)
                .append(taggerHandler)
                .build()
                .execute(note.rawContent)
        }

        // attendre que la note soit sauvegardé et que les tokens soient processé
        // avant dexecuter le mapping
        val savedNoteDto = savedNoteDtoJob.await()
        val processedTokensMap = tokenProcessingJob.await()

        val noteTokens = processedTokensMap?.map { (key, value) ->
            NoteTokenEntity(
                savedNoteDto.id ?: throw Exception("no id???") , // TODO: Handle with a custom exception
                key,
                value
            )
        } ?: throw Exception("no tokens???") // TODO: Handle with a custom exception


        coroutineScope {
            // coroutineScope block l'execution de la fonction jusqu'a ce que tous les childJobs
            // sont completer
            launch { noteTokenRepository.saveAll(noteTokens).collect {  } }
        }

        return@withContext savedNoteDto
    }

    suspend fun deleteNote(id: Long) = noteRepository.deleteById(id)

    suspend fun updateNote(note: NoteDto) = noteRepository.save(note.toEntity())

}