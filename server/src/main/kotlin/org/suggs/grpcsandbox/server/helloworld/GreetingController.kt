package org.suggs.grpcsandbox.server.helloworld

import io.swagger.annotations.Api
import io.swagger.annotations.ApiOperation
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import java.util.concurrent.atomic.AtomicLong

@RestController
@Api(description =  "Greeting REST controller")
class GreetingController {

    private val counter: AtomicLong = AtomicLong()

    @ApiOperation("Says hello")
    @GetMapping("/greeting")
    fun greeting(@RequestParam(value = "name", defaultValue = "world") name: String): Greeting {
        return Greeting(counter.incrementAndGet(), "producer", "Hello, $name")
    }

    data class Greeting(val id: Long, val from: String, val greeting: String)
}