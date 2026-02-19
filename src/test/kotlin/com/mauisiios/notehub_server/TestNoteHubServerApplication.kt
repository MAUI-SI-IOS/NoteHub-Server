package com.mauisiios.notehub_server

import org.springframework.boot.fromApplication
import org.springframework.boot.with


fun main(args: Array<String>) {
    fromApplication<NoteHubServerApplication>().with(TestcontainersConfiguration::class).run(*args)
}
