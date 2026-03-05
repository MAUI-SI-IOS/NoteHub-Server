package com.mauisiios.notehub_server.data.repo

import com.mauisiios.notehub_server.data.entity.TokenEntity
import org.springframework.data.r2dbc.repository.Query
import org.springframework.data.repository.kotlin.CoroutineCrudRepository

interface TokenRepository: CoroutineCrudRepository<TokenEntity,String> {
    @Query("""
        INSERT INTO token (token) 
        SELECT unnest(:tokens) 
        ON CONFLICT (token) DO NOTHING
    """)
    suspend fun saveAllUnique(tokens: Array<String>)

}