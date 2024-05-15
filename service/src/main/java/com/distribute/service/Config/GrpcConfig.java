package com.distribute.service.Config;

import com.distribute.grpc.BackupServiceGrpc;
import com.distribute.service.service.DirectoryService;
import com.distribute.service.service.FileService;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.Server;
import io.grpc.ServerBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GrpcConfig {

     @Bean
     public Server grpcFileServer(FileService fileService,DirectoryService directoryService) {
         return ServerBuilder
                 .forPort(9090) // 选择一个合适的端口
                 .addService(fileService)
                 .addService(directoryService)
                 .build();
     }

     @Bean
     public BackupServiceGrpc.BackupServiceBlockingStub backupServiceBlockingStub() {
         ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 9091)
                 .usePlaintext()
                 .build();

         return BackupServiceGrpc.newBlockingStub(channel);
     }

}
