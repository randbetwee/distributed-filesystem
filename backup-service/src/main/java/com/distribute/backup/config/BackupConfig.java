package com.distribute.backup.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.distribute.backup.service.BackupService;

import io.grpc.Server;
import io.grpc.ServerBuilder;

@Configuration
@ComponentScan(value = "com.distribute")
public class BackupConfig {


    @Bean
    public Server grpcFileServer(BackupService fileService) {
         return ServerBuilder
                 .forPort(9091) // 选择一个合适的端口
                 .addService(fileService)
                 .build();
     }
}
