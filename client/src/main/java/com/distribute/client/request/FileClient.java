package com.distribute.client.request;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.distribute.grpc.FileRequest;
import com.distribute.grpc.FileRequestBrif;
import com.distribute.grpc.FileResponse;
import com.distribute.grpc.FileServiceGrpc;
import com.google.protobuf.ByteString;

@Service
public class FileClient {

    private final FileServiceGrpc.FileServiceBlockingStub fileServiceBlockingStub;

    @Autowired
    public FileClient(FileServiceGrpc.FileServiceBlockingStub fileServiceBlockingStub) {
        this.fileServiceBlockingStub = fileServiceBlockingStub;
    }

    public boolean download(String path){      //第一个字符不要加/
        FileResponse response=fileServiceBlockingStub.download(FileRequestBrif.newBuilder().setFileName(path).build());

        File file = new File(path);

        try(FileOutputStream fos = new FileOutputStream(file)){
            fos.write(response.getContent().toByteArray());
            fos.flush();

            return true;
        } catch (IOException e) {
            e.printStackTrace();

            return false;
        }

    }

    public void upload(String path,byte[] content){
        FileRequest fileRequest=FileRequest.newBuilder().setFileName(path)
                .setContent(ByteString.copyFrom(content)).build();


        FileResponse fileResponse=fileServiceBlockingStub.upload(fileRequest);

        System.out.println(fileResponse.getContent().toStringUtf8());

    }

    public void update(String path,byte[] content){
        FileRequest fileRequest=FileRequest.newBuilder().setFileName(path)
                .setContent(ByteString.copyFrom(content)).build();


        FileResponse fileResponse=fileServiceBlockingStub.update(fileRequest);

        System.out.println(fileResponse.getContent().toStringUtf8());
    }

    public void delete(String fileName) {
        FileRequestBrif request = FileRequestBrif.newBuilder()
                .setFileName(fileName)
                .build();

        FileResponse response = fileServiceBlockingStub.delete(request);

        // Process the response as needed
        System.out.println("Delete response content size: " + response.getContent().size());
    }

    public void commit(String fileName){
        FileResponse response=fileServiceBlockingStub.commit(FileRequestBrif.newBuilder()
                .setFileName(fileName).build());

    }

}
