package com.hyuki.korelloflux

import com.hyuki.korelloflux.domain.event.model.Event
import com.hyuki.korelloflux.domain.event.service.EventService
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
class KorelloFluxApplicationTests {

    @Autowired
    lateinit var eventService: EventService

    @Test
    fun contextLoads() {
        eventService.saveEvent(Event("1","2","3",4,"5","6"))
        println("11")
    }

}
