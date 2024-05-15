package com.distribute.service.service;

import com.distribute.grpc.HelloRequest;
import com.distribute.grpc.HelloResp;
import com.distribute.grpc.HelloWorldGrpc;
import io.grpc.stub.StreamObserver;
import net.devh.boot.grpc.server.service.GrpcService;

/**
 * @Author: Thomas
 * @Date: 2023-10-05  21:56:45
 * @Description:
 */
@GrpcService
public class service extends HelloWorldGrpc.HelloWorldImplBase {
    @Override
    public void sayHello(HelloRequest request, StreamObserver<HelloResp> responseObserver) {
        String name = request.getName();
        int id = request.getId();
        System.out.println(name + " ---------------------- " + id);
        /**
         * 这里可以写具体的业务逻辑进行实现！！！！
         */
        HelloResp helloResp = HelloResp.newBuilder()
                .setSchool("DMU")
                .setAddress("贵州遵义")
                .setAge(123)
                .build();
        responseObserver.onNext(helloResp);
        responseObserver.onCompleted();
    }
}