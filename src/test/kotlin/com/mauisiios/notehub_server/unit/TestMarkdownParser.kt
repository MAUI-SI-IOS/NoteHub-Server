package com.mauisiios.notehub_server.unit

import com.mauisiios.notehub_server.model.NoteFormattedExpressionType
import com.mauisiios.notehub_server.rescource.MardownTestRescourceStore
import com.mauisiios.notehub_server.service.MarkdownParserService
import kotlinx.coroutines.test.runTest
import org.junit.jupiter.api.Test
import org.springframework.core.io.DefaultResourceLoader
import org.springframework.util.Assert

class TestMarkdownParser {

    private val markdownResourceLoader = MardownTestRescourceStore(DefaultResourceLoader())
    private val markdownParser = MarkdownParserService()

    @Test
    fun `Test plain text single-line markdown`() = runTest {
        val result = markdownParser.parse(
            markdownResourceLoader.plainTextSample
        )

        Assert.notNull(result, "result should not be null")
        Assert.notEmpty(result, "result should not be empty")
        Assert.noNullElements(result, "result should not contain null elements")
        Assert.state(result.size == 1, "result should only have one expression")
        Assert.state(result[0].type == NoteFormattedExpressionType.PlainText, "result should be a plain text expression")
        Assert.state(result[0].content == "This is a plain text expression", "result should contain the correct content")
    }

    @Test
    fun `Test header level 1 single-line markdown`() = runTest {
        val result = markdownParser.parse(
            markdownResourceLoader.headerLevel1Sample
        )

        Assert.notNull(result, "result should not be null")
        Assert.notEmpty(result, "result should not be empty")
        Assert.noNullElements(result, "result should not contain null elements")
        Assert.state(result.size == 1, "result should only have one expression")
        Assert.state(result[0].type is NoteFormattedExpressionType.Header, "result type should be a header")
        Assert.state((result[0].type as NoteFormattedExpressionType.Header).level == 1, "result header level should be 1")
        Assert.state(result[0].content == "This is a header level 1", "result should contain the correct content")
    }

    @Test
    fun `Test header level 4 single-line markdown`() = runTest {
        val result = markdownParser.parse(
            markdownResourceLoader.headerLevel4Sample
        )

        Assert.notNull(result, "result should not be null")
        Assert.notEmpty(result, "result should not be empty")
        Assert.noNullElements(result, "result should not contain null elements")
        Assert.state(result.size == 1, "result should only have one expression")
        Assert.state(result[0].type is NoteFormattedExpressionType.Header, "result type should be a header")
        Assert.state((result[0].type as NoteFormattedExpressionType.Header).level == 4, "result header level should be 4")
        Assert.state(result[0].content == "This is a header level 4", "result should contain the correct content")
    }

    @Test
    fun `Test link single-line markdown`() = runTest {
        val result = markdownParser.parse(
            markdownResourceLoader.linkSample
        )

        Assert.notNull(result, "result should not be null")
        Assert.notEmpty(result, "result should not be empty")
        Assert.noNullElements(result, "result should not contain null elements")
        Assert.state(result.size == 2, "result should have two expressions")
        Assert.state(result[1].type is NoteFormattedExpressionType.Link, "result type should be a link")
        Assert.state((result[1].type as NoteFormattedExpressionType.Link).url == "#url-to-note", "result url should be #url-to-note")
        Assert.state(result[1].content == "This text will be shown", "result should contain the correct content")
    }

    @Test
    fun `Test unordered list single-line markdown`() = runTest {
        val result = markdownParser.parse(
            markdownResourceLoader.unorderedListSample
        )

        Assert.notNull(result, "result should not be null")
        Assert.notEmpty(result, "result should not be empty")
        Assert.noNullElements(result, "result should not contain null elements")
        Assert.state(result.size == 3, "result should have three expressions")
        Assert.state(result.all { it.type is NoteFormattedExpressionType.ListItem.Unordered }, "result type should be Unordered ListItem")
        Assert.state(result[0].content == "List Item 1", "result[0] should contain the correct content")
        Assert.state(result[1].content == "List Item 2", "result[1] should contain the correct content")
        Assert.state(result[2].content == "List Item 3", "result[2] should contain the correct content")
    }

    @Test
    fun `Test ordered list single-line markdown`() = runTest {
        val result = markdownParser.parse(
            markdownResourceLoader.orderedListSample
        )

        Assert.notNull(result, "result should not be null")
        Assert.notEmpty(result, "result should not be empty")
        Assert.noNullElements(result, "result should not contain null elements")
        Assert.state(result.size == 3, "result should have three expressions")
        Assert.state(
            result.all { it.type is NoteFormattedExpressionType.ListItem.Ordered },
            "result type should be Ordered ListItem"
        )
        Assert.state(result[0].content == "Ordered List Item 1", "result[0] should contain the correct content")
        Assert.state(result[1].content == "Ordered List Item 2", "result[1] should contain the correct content")
        Assert.state(result[2].content == "Ordered List Item 3", "result[2] should contain the correct content")
    }

    @Test
    fun `Test checklist single-line markdown`() = runTest {
        val result = markdownParser.parse(
            markdownResourceLoader.checklistSample
        )

        Assert.notNull(result, "result should not be null")
        Assert.notEmpty(result, "result should not be empty")
        Assert.noNullElements(result, "result should not contain null elements")
        Assert.state(result.size == 4, "result should have four expressions")
        Assert.state(result.all { it.type is NoteFormattedExpressionType.ListItem.CheckBox }, "result type should be CheckBox ListItem")
        Assert.state(result[0].content == "Todo 1", "result[0] should contain the correct content")
        Assert.state(result[1].content == "Todo 2", "result[1] should contain the correct content")
        Assert.state(result[2].content == "Done 3", "result[2] should contain the correct content")
        Assert.state(result[3].content == "Todo 4", "result[3] should contain the correct content")
        Assert.state(listOf(result[0].type, result[1].type, result[3].type).all { it is NoteFormattedExpressionType.ListItem.CheckBox && !it.checked },"result[0], result[1] and result[3] should be unchecked")
        Assert.state(result[2].type.let { it is NoteFormattedExpressionType.ListItem.CheckBox && it.checked }, "result[2] should be checked")
    }

    @Test
    fun `Test multiline text single-line markdown`() = runTest {
        val result = markdownParser.parse(
            markdownResourceLoader.multilineTextSample
        )

        Assert.notNull(result, "result should not be null")
        Assert.notEmpty(result, "result should not be empty")
        Assert.noNullElements(result, "result should not contain null elements")
        Assert.state(result.size == 1, "result should only have one expression")
        result[0].let { resultedExpression ->
            Assert.state(resultedExpression.type == NoteFormattedExpressionType.PlainText, "result should be a plain text expression")
            Assert.state(resultedExpression.content == "This\nis\na\nmulti-line\nplain\ntext", "result should contain the correct content")
        }
    }

    @Test
    fun `Test two paragraph text single-line markdown`() = runTest {
        val result = markdownParser.parse(
            markdownResourceLoader.twoParagraphTextSample
        )

        Assert.notNull(result, "result should not be null")
        Assert.notEmpty(result, "result should not be empty")
        Assert.noNullElements(result, "result should not contain null elements")
        Assert.state(result.size == 2, "result should have two expressions")
        result[0].let { first ->
            Assert.state(first.type == NoteFormattedExpressionType.PlainText, "result[0] should be a plain text expression")
            Assert.state(first.content == "This is a paragraph", "result[0] should contain the correct content")
        }
        result[1].let { second ->
            Assert.state(second.type == NoteFormattedExpressionType.PlainText, "result[1] should be a plain text expression")
            Assert.state(second.content == "This is a second paragraph", "result[1] should contain the correct content")
        }
    }
}