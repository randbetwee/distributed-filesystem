package com.distribute.client;

import com.distribute.grpc.HelloRequest;
import com.distribute.grpc.HelloResp;
import com.distribute.grpc.HelloWorldGrpc;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ClientApplication {

    public static void main(String[] args) {
        SpringApplication.run(ClientApplication.class, args);

    }

}