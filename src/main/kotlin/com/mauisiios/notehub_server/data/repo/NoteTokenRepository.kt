package com.mauisiios.notehub_server.data.repo

import com.mauisiios.notehub_server.data.entity.NoteEntity
import com.mauisiios.notehub_server.data.entity.NoteTokensEntity
import com.mauisiios.notehub_server.data.entity.TokenEntity
import kotlinx.coroutines.flow.Flow
import org.springframework.data.r2dbc.repository.Query
import org.springframework.data.repository.kotlin.CoroutineCrudRepository

interface NoteTokenRepository : CoroutineCrudRepository<NoteTokensEntity,Long> {

    @Query("""SELECT t* FROM token t
            JOIN note_token nt on t.token = nt.tokenId
            WHERE nt.noteId = :noteId""")
    suspend fun findAllTokensByNoteId(noteId: Long): Flow<TokenEntity>

    @Query("""SELECT n* FROM note n
            JOIN note_token nt ON n.id = nt.noteId
            WHERE nt.tokenId = :token""")
    suspend fun findAllNotesByTokenId(token: String): Flow<NoteEntity>
}