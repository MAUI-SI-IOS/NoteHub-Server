package com.mauisiios.notehub_server.data.converter

import com.mauisiios.notehub_server.model.NoteFormattedExpression
import io.r2dbc.postgresql.codec.Json
import org.springframework.core.convert.converter.Converter
import org.springframework.data.convert.ReadingConverter
import org.springframework.data.convert.WritingConverter
import org.springframework.stereotype.Component
import tools.jackson.core.type.TypeReference
import tools.jackson.databind.ObjectMapper

@Component
@WritingConverter
class NoteFormattedExpressionWritingConverter(
    private val objectMapper: ObjectMapper
) : Converter<List<NoteFormattedExpression>, Json> {
    override fun convert(source: List<NoteFormattedExpression>): Json {
        return Json.of(objectMapper.writeValueAsString(source))
    }
}

@Component
@ReadingConverter
class NoteFormattedExpressionReadingConverter(
    private val objectMapper: ObjectMapper
) : Converter<Json, List<NoteFormattedExpression>> {
    override fun convert(source: Json): List<NoteFormattedExpression> {
        return objectMapper.readValue(source.asString(), object : TypeReference<List<NoteFormattedExpression>>() {})
    }
}
