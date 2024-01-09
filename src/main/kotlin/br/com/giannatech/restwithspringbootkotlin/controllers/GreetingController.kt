package br.com.giannatech.restwithspringbootkotlin.controllers

import br.com.giannatech.restwithspringbootkotlin.Greeting
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import java.util.concurrent.atomic.AtomicLong

@RestController
@RequestMapping("/api/greetings")
class GreetingController {

    val counter: AtomicLong = AtomicLong()

    @GetMapping
    fun greeting(@RequestParam(value = "name", defaultValue = "Kotlin") name: String?): Greeting {
        return Greeting(counter.incrementAndGet(), "Hello, $name!")
    }
}