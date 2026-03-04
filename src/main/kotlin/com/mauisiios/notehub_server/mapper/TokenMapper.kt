package com.mauisiios.notehub_server.mapper

import com.mauisiios.notehub_server.data.entity.TokenEntity
import com.mauisiios.notehub_server.dto.TokenDto


fun TokenDto.toEntity() = TokenEntity(
    token = this.token,
)

fun TokenEntity.toDto() = TokenDto(
    token = this.token,
)
