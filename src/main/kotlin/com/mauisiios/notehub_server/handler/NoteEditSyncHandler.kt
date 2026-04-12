package com.mauisiios.notehub_server.handler

import com.mauisiios.notehub_server.dto.ws.UpdateNoteSyncAction
import com.mauisiios.notehub_server.mapper.toDto
import com.mauisiios.notehub_server.service.NoteService
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.reactive.asFlow
import kotlinx.coroutines.reactive.asPublisher
import org.springframework.stereotype.Component
import org.springframework.web.reactive.socket.WebSocketHandler
import org.springframework.web.reactive.socket.WebSocketSession
import reactor.core.publisher.Mono
import tools.jackson.core.JacksonException
import tools.jackson.databind.ObjectMapper

@Component
class NoteEditSyncHandler(
    private val objectMapper: ObjectMapper,
    private val noteService: NoteService
): WebSocketHandler {
    override fun handle(session: WebSocketSession): Mono<Void> {

        val outputFlow = session.receive()
            .asFlow()
            .map { wsMessage ->
                val payload = wsMessage.payloadAsText
                val responseTxt = try {
                    // get the action from the JSON string
                    val updateAction = objectMapper.readValue(
                        payload,
                        UpdateNoteSyncAction::class.java
                    )
                    // update the note through the service and get the updated note
                    val note = noteService.updateNote(
                        updateAction.toDto()
                    )
                    // return the updated note as a JSON string
                    objectMapper.writeValueAsString(note)
                } catch (e: JacksonException) {
                    "Invalid JSON"
                }
                session.textMessage(responseTxt)
            }

        return session.send(
            outputFlow.asPublisher()
        )
    }

}