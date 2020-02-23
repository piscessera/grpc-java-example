package org.example.grpc.app;

import io.grpc.stub.StreamObserver;
import org.example.grpc.server.HelloRequest;
import org.example.grpc.server.HelloResponse;
import org.example.grpc.server.HelloServiceGrpc;
import org.lognet.springboot.grpc.GRpcService;

@GRpcService
public class HelloServiceImpl extends HelloServiceGrpc.HelloServiceImplBase {
//    @Override
//    public void hello(HelloRequest request, StreamObserver<HelloResponse> responseObserver) {
//        System.out.println(request);
//
//        HelloResponse response = HelloResponse.newBuilder().setGreeting("GRPC Hello: " + request.getFirstName() + " " + request.getLastName()).build();
//
//        responseObserver.onNext(response);
//        responseObserver.onCompleted();
//    }

    @Override
    public void hello(HelloRequest request, StreamObserver<HelloResponse> responseObserver) {
        System.out.println(request);

        HelloResponse response = HelloResponse.newBuilder().setGreeting("GRPC Hello: " + request.getFirstName() + " " + request.getLastName()).build();

        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }
}
