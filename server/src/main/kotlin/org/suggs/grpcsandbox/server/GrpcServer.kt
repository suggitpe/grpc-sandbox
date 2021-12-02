package org.suggs.grpcsandbox.server

import org.springframework.boot.Banner.Mode.OFF
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
open class GrpcServer

fun main(args: Array<String>) {
    runApplication<GrpcServer>(*args) {
        setBannerMode(OFF)
    }
}