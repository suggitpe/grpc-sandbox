package org.suggs.grpcsandbox.server.support

import io.swagger.v3.oas.models.OpenAPI
import io.swagger.v3.oas.models.info.Info
import io.swagger.v3.oas.models.info.License
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
open class ApplicationConfiguration {

    @Bean
    open fun customOpenApi(): OpenAPI = OpenAPI()
        .info(customApiInfo())

    private fun customApiInfo() = Info()
        .title("API Documentation: GRPC Sandbox")
        .description("An application to show how to use protobuf.")
        .version("1.0.0")
        .termsOfService("http://swagger.io/terms/")
        .license(License().name("Apache 2.0"))
}