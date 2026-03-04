package com.mauisiios.notehub_server.data.repo

import com.mauisiios.notehub_server.data.entity.TokenEntity
import org.springframework.data.repository.kotlin.CoroutineCrudRepository

interface TokenRepository: CoroutineCrudRepository<TokenEntity,String> {
}