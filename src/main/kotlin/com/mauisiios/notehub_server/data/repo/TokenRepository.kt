package com.mauisiios.notehub_server.data.repo

import org.springframework.data.repository.kotlin.CoroutineCrudRepository

interface TokenRepository: CoroutineCrudRepository<TokenEntity,Word> {
}