package com.mauisiios.notehub_server.model

import com.fasterxml.jackson.annotation.JsonSubTypes
import com.fasterxml.jackson.annotation.JsonTypeInfo
import com.fasterxml.jackson.annotation.JsonTypeName

private const val HEADER_TYPE_NAME = "Header"
private const val LINK_TYPE_NAME = "Link"
private const val PLAIN_TEXT_TYPE_NAME = "PlainText"
private const val UNORDERED_LIST_TYPE_NAME = "Unordered"
private const val ORDERED_LIST_TYPE_NAME = "Ordered"
private const val CHECKBOX_LIST_TYPE_NAME = "CheckBox"


@JsonTypeInfo(
    use = JsonTypeInfo.Id.NAME,
    include = JsonTypeInfo.As.PROPERTY,
    property = "name"
)
@JsonSubTypes(
    JsonSubTypes.Type(value = NoteFormattedExpressionType.Header::class, name = HEADER_TYPE_NAME),
    JsonSubTypes.Type(value = NoteFormattedExpressionType.Link::class, name = LINK_TYPE_NAME),
    JsonSubTypes.Type(value = NoteFormattedExpressionType.PlainText::class, name = PLAIN_TEXT_TYPE_NAME),
    JsonSubTypes.Type(value = NoteFormattedExpressionType.ListItem.Unordered::class, name = UNORDERED_LIST_TYPE_NAME),
    JsonSubTypes.Type(value = NoteFormattedExpressionType.ListItem.Ordered::class, name = ORDERED_LIST_TYPE_NAME),
    JsonSubTypes.Type(value = NoteFormattedExpressionType.ListItem.CheckBox::class, name = CHECKBOX_LIST_TYPE_NAME)
)
sealed interface NoteFormattedExpressionType {

    @JsonTypeName(HEADER_TYPE_NAME)
    data class Header(var level: Int) : NoteFormattedExpressionType
    @JsonTypeName(LINK_TYPE_NAME)
    data class Link(val url: String) : NoteFormattedExpressionType
    @JsonTypeName(PLAIN_TEXT_TYPE_NAME)
    data object PlainText : NoteFormattedExpressionType
    sealed interface ListItem : NoteFormattedExpressionType {
        @JsonTypeName(UNORDERED_LIST_TYPE_NAME)
        data object Unordered : ListItem
        @JsonTypeName(ORDERED_LIST_TYPE_NAME)
        data object Ordered : ListItem
        @JsonTypeName(CHECKBOX_LIST_TYPE_NAME)
        data class CheckBox(val checked: Boolean) : ListItem
    }
}

data class NoteFormattedExpression(
    val type: NoteFormattedExpressionType? = null,
    var content: String = "",
)