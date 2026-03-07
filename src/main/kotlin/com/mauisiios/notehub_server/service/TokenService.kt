package com.mauisiios.notehub_server.service

import com.mauisiios.notehub_server.data.entity.NoteEntity
import com.mauisiios.notehub_server.data.entity.NoteTokenEntity
import com.mauisiios.notehub_server.data.repo.NoteTokenRepository
import com.mauisiios.notehub_server.dto.NoteDto
import com.mauisiios.notehub_server.dto.NoteTokenDto
import com.mauisiios.notehub_server.mapper.toDto
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import org.springframework.stereotype.Service

@Service
class TokenService(
    private val noteTokenRepository: NoteTokenRepository,
) {

    suspend fun getAllNoteByToken(token: String): Flow<NoteDto> =
        noteTokenRepository.findAllNotesByTokenId(token).map(NoteEntity::toDto)

    suspend fun getAllTokenByNote(id: Long): Flow<NoteTokenDto> =
        noteTokenRepository.findAllTokensByNoteId(id).map(NoteTokenEntity::toDto)
}