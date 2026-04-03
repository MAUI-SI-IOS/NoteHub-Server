package com.mauisiios.notehub_server.model

sealed interface NoteFormattedExpressionType {

    data class Header(var level: Int) : NoteFormattedExpressionType
    data class Link(val url: String) : NoteFormattedExpressionType
    data object PlainText : NoteFormattedExpressionType
    sealed interface ListItem : NoteFormattedExpressionType {
        data object Unordered : ListItem
        data object Ordered : ListItem
        data class CheckBox(val checked: Boolean) : ListItem
    }
}

data class NoteFormattedExpression(
    val type: NoteFormattedExpressionType,
    var content: String,
)