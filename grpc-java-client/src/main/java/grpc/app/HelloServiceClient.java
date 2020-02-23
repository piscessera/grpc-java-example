package grpc.app;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.StatusRuntimeException;
import org.example.grpc.server.HelloRequest;
import org.example.grpc.server.HelloResponse;
import org.example.grpc.server.HelloServiceGrpc;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class HelloServiceClient {
    private final ManagedChannel channel;
    private final HelloServiceGrpc.HelloServiceBlockingStub blockingStub;

    public HelloServiceClient(@Value("${hello.service.endpoint}") String endpoint) {
        // Create a communication channel to the server
        this.channel = ManagedChannelBuilder.forTarget(endpoint)
                .usePlaintext()
                .build();

        // Passing channels to code makes code easier to test and makes it easier to reuse channels
        this.blockingStub = HelloServiceGrpc.newBlockingStub(this.channel);
    }

    public HelloResponse hello(String firstName, String lastName) {
        HelloRequest request = HelloRequest.newBuilder()
                .setFirstName(firstName)
                .setLastName(lastName)
                .build();
        System.out.println(request);
        HelloResponse response;
        try {
            response = blockingStub.hello(request);
        } catch (StatusRuntimeException e) {
            e.printStackTrace();
            return null;
        }
        System.out.println(response);
        return response;
    }
}
