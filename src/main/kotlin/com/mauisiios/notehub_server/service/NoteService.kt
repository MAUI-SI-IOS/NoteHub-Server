package com.mauisiios.notehub_server.service

import com.mauisiios.notehub_server.data.entity.NoteEntity
import com.mauisiios.notehub_server.data.entity.NoteTokenEntity
import com.mauisiios.notehub_server.data.repo.NoteRepository
import com.mauisiios.notehub_server.data.repo.NoteTokenRepository
import com.mauisiios.notehub_server.dto.NoteDto
import com.mauisiios.notehub_server.mapper.toDto
import com.mauisiios.notehub_server.mapper.toEntity
import com.mauisiios.notehub_server.service.COR_BUILDER.TokenizerFactory
import kotlinx.coroutines.async
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
        tokenProcessingFlow.collect { (token, _) ->
            // TODO: Set a threshold so that only recurring theme are replaced by links
            contentToFormat = contentToFormat.replace(token, "[$token](#${token})") // Replacing tokens by links to them 
        }

        var parsedContent = markdownParserService.parse(contentToFormat)

        val savedNoteDtoJob = async {
            noteRepository.save(
                note.toEntity()
                    /* NOTE: will be commented out until the conversion is implemented
                    .apply { formattedContent = parsedContent.joinToString(separator = "") { 
                        it.content
                    } } // TODO: should be a JSON object
                     */
            ).toDto()
        }

        // attendre que la note soit sauvegardé et que les tokens soient processé
        // avant dexecuter le mapping
        val savedNoteDto = savedNoteDtoJob.await()


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

    suspend fun updateNote(note: NoteDto) = noteRepository.save(note.toEntity())

}