package com.mauisiios.notehub_server.rescource

import org.springframework.boot.test.context.TestComponent
import org.springframework.core.io.ResourceLoader

@TestComponent
class MardownTestRescourceStore(
    private val resourceLoader: ResourceLoader
) {

    val plainTextSample: String
        get() = resourceLoader.getResource("classpath:markdown/plain_text.md")
                .inputStream.readBytes()
                .toString(Charsets.UTF_8)

    val headerLevel1Sample: String
        get() = resourceLoader.getResource("classpath:markdown/header1.md")
            .inputStream.readBytes()
            .toString(Charsets.UTF_8)


    val headerLevel4Sample: String
        get() = resourceLoader.getResource("classpath:markdown/header4.md")
            .inputStream.readBytes()
            .toString(Charsets.UTF_8)

    val multilineTextSample: String
        get() = resourceLoader.getResource("classpath:markdown/multiline_plain_text.md")
            .inputStream.readBytes()
            .toString(Charsets.UTF_8)

    val twoParagraphTextSample: String
        get() = resourceLoader.getResource("classpath:markdown/two_paragrapgrah_plain_text.md")
            .inputStream.readBytes()
            .toString(Charsets.UTF_8)
    val linkSample: String
        get() = resourceLoader.getResource("classpath:markdown/link.md")
            .inputStream.readBytes()
            .toString(Charsets.UTF_8)

    val unorderedListSample: String
        get() = resourceLoader.getResource("classpath:markdown/unordered_list.md")
            .inputStream.readBytes()
            .toString(Charsets.UTF_8)

    val orderedListSample: String
        get() = resourceLoader.getResource("classpath:markdown/ordered_list.md")
            .inputStream.readBytes()
            .toString(Charsets.UTF_8)

    val checklistSample: String
        get() = resourceLoader.getResource("classpath:markdown/checklist.md")
            .inputStream.readBytes()
            .toString(Charsets.UTF_8)



}