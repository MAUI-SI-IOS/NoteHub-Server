package com.mauisiios.notehub_server

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class NoteHubServerApplication

fun main(args: Array<String>) {
    runApplication<NoteHubServerApplication>(*args)
}
