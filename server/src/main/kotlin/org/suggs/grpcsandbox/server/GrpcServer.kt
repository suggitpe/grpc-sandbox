package org.suggs.grpcsandbox.server

import org.springframework.boot.Banner.Mode.OFF
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import springfox.documentation.swagger2.annotations.EnableSwagger2

@SpringBootApplication
open class GrpcServer

fun main(args: Array<String>) {
    runApplication<GrpcServer>(*args) {
        setBannerMode(OFF)
    }
}