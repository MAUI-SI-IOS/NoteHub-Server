package com.mauisiios.notehub_server.handler

import com.mauisiios.notehub_server.dto.NoteDto
import com.mauisiios.notehub_server.service.NoteService
import kotlinx.coroutines.coroutineScope
import org.springframework.http.MediaType
import org.springframework.stereotype.Component
import org.springframework.web.reactive.function.server.*
import org.springframework.web.reactive.function.server.ServerResponse.ok

@Component
class NoteHandler(
    private val noteService: NoteService
) {
    suspend fun listNotes(request: ServerRequest): ServerResponse = coroutineScope {
        val notes = noteService.getAll()

        ok()
            .contentType(MediaType.APPLICATION_JSON)
            .bodyAndAwait(notes)
    }

    suspend fun getNote(request: ServerRequest): ServerResponse = coroutineScope {
        val id = request.pathVariable("id").toLong()
        val note = noteService.getById(id)
            ?: return@coroutineScope ServerResponse.notFound().buildAndAwait()

        ok()
            .contentType(MediaType.APPLICATION_JSON)
            .bodyValueAndAwait(note)
    }

    /**
     * handler for getting a note by title.
     * title must be a path variable
     */
    suspend fun getNoteByTitle(request: ServerRequest): ServerResponse = coroutineScope {
        val title = request.pathVariable("title")
        val note = noteService.getByTitle(title)
            ?: return@coroutineScope ServerResponse.notFound().buildAndAwait()

        ok()
            .contentType(MediaType.APPLICATION_JSON)
            .bodyValueAndAwait(note)
    }

    suspend fun createNote(request: ServerRequest): ServerResponse = coroutineScope {
        val note = request.awaitBodyOrNull<NoteDto>()
            ?: return@coroutineScope ServerResponse.badRequest()
                .buildAndAwait()

        val createdNote = noteService.createNote(note)

        ok()
            .contentType(MediaType.APPLICATION_JSON)
            .bodyValueAndAwait(createdNote)
    }

    suspend fun updateNote(request: ServerRequest): ServerResponse = coroutineScope {
        val note = request.awaitBodyOrNull<NoteDto>()
            ?: return@coroutineScope ServerResponse.badRequest()
                .buildAndAwait()

        val updatedNote = noteService.updateNote(note)

        ok()
            .contentType(MediaType.APPLICATION_JSON)
            .bodyValueAndAwait(updatedNote)
    }

    suspend fun deleteNote(request: ServerRequest): ServerResponse = coroutineScope {
        val id = request.pathVariable("id")
            .toLong()
        noteService.deleteNote(id)

        ServerResponse.noContent()
            .buildAndAwait()
    }
}