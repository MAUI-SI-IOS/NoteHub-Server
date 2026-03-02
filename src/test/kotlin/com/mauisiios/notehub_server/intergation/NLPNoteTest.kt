package com.mauisiios.notehub_server.intergation

import com.mauisiios.notehub_server.service.NLPService
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
class NLPNoteTest(@Autowired val service: NLPService) {

    @Test
    fun testCreateNote() {
        println(service.analyze("Je suis alle a la plag"));
    }
}