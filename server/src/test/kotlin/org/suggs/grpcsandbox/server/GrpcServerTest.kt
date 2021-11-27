package org.suggs.grpcsandbox.server

import io.grpc.ManagedChannelBuilder
import io.kotest.matchers.comparables.shouldBeLessThanOrEqualTo
import io.kotest.matchers.shouldBe
import io.kotest.matchers.shouldNotBe
import org.junit.jupiter.api.Test
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT
import org.springframework.boot.web.server.LocalServerPort
import org.springframework.test.context.ContextConfiguration
import org.suggs.grpcsandbox.proto.helloworld.GreeterGrpcKt
import org.suggs.grpcsandbox.proto.helloworld.HelloRequest

@ContextConfiguration
@SpringBootTest(webEnvironment = RANDOM_PORT)
class GrpcServerTest {

    @LocalServerPort
    private val localPort = -1

    @Test
    fun `check the server has started and been allocated a port`() {
        localPort shouldNotBe -1
    }

    @Test
    suspend fun `sanity check with a hello world example`() {
        val channel = ManagedChannelBuilder.forAddress("localhost", localPort).usePlaintext().build()
        val stub = GreeterGrpcKt.GreeterCoroutineStub(channel)
        val response = stub.sayHello(HelloRequest.newBuilder().setName("Foobar").build())
        response.message shouldBe "hello"
        channel.shutdown()
    }
}