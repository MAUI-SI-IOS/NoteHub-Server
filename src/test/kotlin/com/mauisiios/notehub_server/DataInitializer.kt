package com.mauisiios.notehub_server

import com.mauisiios.notehub_server.dto.NoteDto
import com.mauisiios.notehub_server.service.NoteService
import kotlinx.coroutines.test.runTest
import org.springframework.boot.ApplicationArguments
import org.springframework.boot.ApplicationRunner
import org.springframework.stereotype.Component


@Component
class DataInitializer(
    private val noteService: NoteService,
): ApplicationRunner
{


    override fun run(args: ApplicationArguments):Unit = runTest {
        (1..10).forEach { i ->
            val dto = NoteDto(
                title = "Note $i",
                rawContent = "Content for note $i",
                formattedContent = "Formatted content for note $i"
            )
            noteService.createNote(dto)
        }
    }
}