package org.suggs.grpcsandbox.server.helloworld

import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.tags.Tag
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import java.util.concurrent.atomic.AtomicLong

@RestController
@Tag(name = "GreetingController", description = "Greeting REST controller")
class GreetingController {

    private val counter: AtomicLong = AtomicLong()

    @Operation(summary = "Says hello")
    @GetMapping("/greeting")
    fun greeting(@RequestParam(value = "name", defaultValue = "world") name: String): Greeting {
        return Greeting(counter.incrementAndGet(), "producer", "Hello, $name")
    }

    data class Greeting(val id: Long, val from: String, val greeting: String)
}