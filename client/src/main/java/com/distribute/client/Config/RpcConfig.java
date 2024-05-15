package com.distribute.client.Config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.distribute.grpc.DirectoryServiceGrpc;
import com.distribute.grpc.FileServiceGrpc;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

@Configuration
public class RpcConfig {
    
    @Bean
    public DirectoryServiceGrpc.DirectoryServiceBlockingStub directoryServiceBlockingStub() {
        ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 9090)
                .usePlaintext()
                .build();

        return DirectoryServiceGrpc.newBlockingStub(channel);
    }

    @Bean
    public FileServiceGrpc.FileServiceBlockingStub fileServiceBlockingStub() {
        ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 9090)
                .usePlaintext()
                .build();

        return FileServiceGrpc.newBlockingStub(channel);
    }


}
