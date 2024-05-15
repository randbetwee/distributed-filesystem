package com.distribute.client.request;

import com.distribute.grpc.MkdirResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.distribute.grpc.DirectoryServiceGrpc;
import com.distribute.grpc.LsRequest;
import com.distribute.grpc.LsResponse;

@Service
public class DirectoryRequest {

    private final DirectoryServiceGrpc.DirectoryServiceBlockingStub directoryServiceBlockingStub;

    @Autowired
    public DirectoryRequest(DirectoryServiceGrpc.DirectoryServiceBlockingStub directoryServiceBlockingStub) {
        this.directoryServiceBlockingStub = directoryServiceBlockingStub;
    }

    public void Ls(String path) {
        LsResponse response = directoryServiceBlockingStub.ls(LsRequest.newBuilder().setPath(path).build());

        // Process the response as needed

        response.getFilenamesList().forEach(System.out::println);
    }

    public void mkdir(String path){
        try {
            MkdirResponse request = directoryServiceBlockingStub.mkdir(LsRequest.newBuilder().setPath(path).build());
            if (request.getStatus())
                System.out.println("create path completed");
        }catch(Exception e){
            System.out.println("create failed,check your path");
        }
    }


    public boolean cd(String path){

            MkdirResponse request = directoryServiceBlockingStub.mkdir(LsRequest.newBuilder().setPath(path).build());
            return request.getStatus();

    }

}
