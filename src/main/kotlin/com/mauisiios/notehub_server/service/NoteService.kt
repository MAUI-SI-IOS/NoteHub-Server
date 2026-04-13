package com.mauisiios.notehub_server.service

import com.mauisiios.notehub_server.data.entity.NoteEntity
import com.mauisiios.notehub_server.data.entity.NoteTokenEntity
import com.mauisiios.notehub_server.data.repo.NoteRepository
import com.mauisiios.notehub_server.data.repo.NoteTokenRepository
import com.mauisiios.notehub_server.dto.NoteDto
import com.mauisiios.notehub_server.mapper.toDto
import com.mauisiios.notehub_server.mapper.toEntity
import com.mauisiios.notehub_server.service.COR_BUILDER.TokenizerFactory
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.count
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch
import org.springframework.stereotype.Service

@Service
class NoteService(
    private val noteRepository: NoteRepository,
    private val noteTokenRepository: NoteTokenRepository,
    private val markdownParserService: MarkdownParserService
) {
    companion object {
        const val CREATE_LINK_FROM_TOKEN_THRESHOLD = 3
    }

    fun getAll(): Flow<NoteDto> = noteRepository.findAll()
        .map(NoteEntity::toDto)

    suspend fun getById(id: Long): NoteDto? = noteRepository.findById(id)
        ?.toDto()

    suspend fun getByTitle(title: String): NoteDto? = noteRepository.findByTitle(title)
        ?.toDto()

    suspend fun createNote(note: NoteDto): NoteDto = coroutineScope { // Optimise les routines pour les requete reseau/db
        val tokenProcessingFlow = TokenizerFactory.tokenize(note.rawContent)
            ?: throw Exception("no tokens???") // TODO: change for a specific Exception for better handling

        var contentToFormat = note.rawContent
        tokenProcessingFlow.collect { (token, _) -> // NOTE: linking to exist
            // Only create links for tokens that are already present in other notes (themes)
            val tokenOccurenceInAllNotes = noteTokenRepository.findAllNotesByTokenId(token)
                .count()
            if (tokenOccurenceInAllNotes > CREATE_LINK_FROM_TOKEN_THRESHOLD) {
                contentToFormat = contentToFormat.replace(token, "[$token](#${token.replace(" ", "-")})")
            }
        }

        var parsedContent = markdownParserService.parse(contentToFormat)
        
        val savedNoteDto = noteRepository.save(
            note.toEntity().apply {
                formattedContent = parsedContent
            }
        ).toDto()

        val noteTokens = tokenProcessingFlow.map { (key, value) ->
            NoteTokenEntity(
                savedNoteDto.id ?: throw Exception("no id???") , // TODO: Handle with a custom exception
                key,
                value
            )
        }

        launch { noteTokenRepository.saveAll(noteTokens).count() }

        return@coroutineScope savedNoteDto
    }

    suspend fun deleteNote(id: Long) = noteRepository.deleteById(id)

    suspend fun updateNote(note: NoteDto): NoteDto = coroutineScope {
        val tokenProcessingFlow = TokenizerFactory.tokenize(note.rawContent)
            ?: throw Exception("no tokens???") // TODO: change for a specific Exception for better handling
        
        var contentToFormat = note.rawContent
        tokenProcessingFlow.collect { (token, _) ->
            // Only create links for tokens that are already present in other notes (
            val tokenOccurenceInAllNotes = noteTokenRepository.findAllNotesByTokenId(token)
                .count { it.id != note.id }
            if (tokenOccurenceInAllNotes > CREATE_LINK_FROM_TOKEN_THRESHOLD) 
                contentToFormat = contentToFormat.replace(token, "[$token](#${token.replace(" ", "-")})")
        }

        var parsedContent = markdownParserService.parse(contentToFormat)

        val savedNoteDto = noteRepository.save(
            note.toEntity().apply {
                formattedContent = parsedContent
            }
        ).toDto()

        val noteTokens = tokenProcessingFlow.map { (key, value) ->
            NoteTokenEntity(
                savedNoteDto.id
                    ?: throw Exception("no id???"), // TODO: Handle with a custom exception
                key,
                value
            )
        }
        
        launch { noteTokenRepository.saveAll(noteTokens).count() }

        return@coroutineScope savedNoteDto
    }

}