package org.suggs.grpcsandbox.server.helloworld

import org.suggs.grpcsandbox.proto.helloworld.GreeterGrpcKt

private class HelloWorldService: GreeterGrpcKt.GreeterCoroutineImplBase() {
}