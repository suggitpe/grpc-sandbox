package org.suggs.grpcsandbox.server.helloworld

import net.devh.boot.grpc.server.service.GrpcService
import org.suggs.grpcsandbox.proto.helloworld.GreeterGrpcKt
import org.suggs.grpcsandbox.proto.helloworld.HelloReply
import org.suggs.grpcsandbox.proto.helloworld.HelloRequest


@GrpcService
class HelloWorldService : GreeterGrpcKt.GreeterCoroutineImplBase() {

    override suspend fun sayHello(request: HelloRequest) =
        HelloReply.newBuilder()
            .setMessage("Hello ==> " + request.name)
            .build()
}