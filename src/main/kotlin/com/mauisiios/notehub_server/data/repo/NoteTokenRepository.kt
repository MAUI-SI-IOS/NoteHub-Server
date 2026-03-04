package com.mauisiios.notehub_server.data.repo

import com.mauisiios.notehub_server.data.entity.NoteTokenId
import com.mauisiios.notehub_server.data.entity.NoteTokensEntity
import com.mauisiios.notehub_server.data.entity.TokenEntity
import org.springframework.data.repository.kotlin.CoroutineCrudRepository

interface NoteTokenRepository : CoroutineCrudRepository<NoteTokensEntity,  NoteTokenId> {
}