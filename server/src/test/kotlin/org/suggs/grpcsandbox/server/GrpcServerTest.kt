package org.suggs.grpcsandbox.server

import org.junit.jupiter.api.Test
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT
import org.springframework.boot.web.server.LocalServerPort
import org.springframework.test.context.ContextConfiguration

@ContextConfiguration
@SpringBootTest(webEnvironment = RANDOM_PORT)
class GrpcServerTest {

    @LocalServerPort
    private val localPort = -1

    @Test
    fun `check the server starts`() {

    }
}