package com.mauisiios.notehub_server.data.repo

import com.mauisiios.notehub_server.data.entity.NoteEntity
import com.mauisiios.notehub_server.data.entity.NoteTokenEntity
import kotlinx.coroutines.flow.Flow
import org.springframework.data.r2dbc.repository.Query
import org.springframework.data.repository.kotlin.CoroutineCrudRepository

interface NoteTokenRepository : CoroutineCrudRepository<NoteTokenEntity,String> {

    @Query("""SELECT * FROM note_token nt 
                     WHERE nt.note_id = :noteId""")
    suspend fun findAllTokensByNoteId(noteId: Long): Flow<NoteTokenEntity>

    @Query("""SELECT * FROM note n
                     JOIN note_token nt on nt.note_id = n.id
                     WHERE nt.token = :token""")
    suspend fun findAllNotesByTokenId(token: String): Flow<NoteEntity>
}