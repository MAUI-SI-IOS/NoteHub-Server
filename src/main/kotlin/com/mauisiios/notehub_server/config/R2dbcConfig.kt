package com.mauisiios.notehub_server.config

import com.mauisiios.notehub_server.data.converter.NoteFormattedExpressionReadingConverter
import com.mauisiios.notehub_server.data.converter.NoteFormattedExpressionWritingConverter
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.data.r2dbc.convert.R2dbcCustomConversions
import org.springframework.data.r2dbc.dialect.PostgresDialect

@Configuration(proxyBeanMethods = false)
class R2dbcConfig(
    private val writingConverter: NoteFormattedExpressionWritingConverter,
    private val readingConverter: NoteFormattedExpressionReadingConverter
) {
    @Bean
    fun r2dbcCustomConversions(): R2dbcCustomConversions {
        return R2dbcCustomConversions.of(
            PostgresDialect.INSTANCE,
            listOf(writingConverter, readingConverter)
        )
    }
}
