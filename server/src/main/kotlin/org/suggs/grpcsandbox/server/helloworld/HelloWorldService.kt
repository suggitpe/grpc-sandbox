package org.suggs.grpcsandbox.server.helloworld

import io.grpc.stub.StreamObserver
import net.devh.boot.grpc.server.service.GrpcService
import org.suggs.grpcsandbox.proto.helloworld.GreeterGrpcKt
import org.suggs.grpcsandbox.proto.helloworld.HelloReply
import org.suggs.grpcsandbox.proto.helloworld.HelloRequest


@GrpcService
class HelloWorldService : GreeterGrpcKt.GreeterCoroutineImplBase() {

    @Override
    fun sayHello(request: HelloRequest, responseObserver: StreamObserver<HelloReply?>) {
        val reply = HelloReply.newBuilder()
            .setMessage("Hello ==> " + request.name)
            .build()
        responseObserver.onNext(reply)
        responseObserver.onCompleted()
    }
}