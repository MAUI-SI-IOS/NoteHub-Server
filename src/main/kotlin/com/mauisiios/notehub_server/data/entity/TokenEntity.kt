package com.mauisiios.notehub_server.data.entity

import org.springframework.data.annotation.Id
import org.springframework.data.domain.Persistable
import org.springframework.data.relational.core.mapping.Table


@Table("token")
data class TokenEntity (
    @Id var token: String
): Persistable<String> {

    override fun getId(): String = token

    // Force Spring to use INSERT instead of UPDATE
    override fun isNew(): Boolean = true
}