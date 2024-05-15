package com.distribute.backup.service;

import com.distribute.grpc.*;
import com.distribute.grpc.BackupServiceGrpc.BackupServiceImplBase;
import com.google.protobuf.ByteString;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;

import net.devh.boot.grpc.server.service.GrpcService;
import org.springframework.beans.factory.annotation.Autowired;

@GrpcService
public class BackupService extends BackupServiceImplBase{
    
    public static final String rootpath="D:/distribute/backupData/";

    @Override
    public void pull(com.distribute.grpc.TransferRequest request,
                     io.grpc.stub.StreamObserver<com.distribute.grpc.TransferStatus> responseObserver){

        try{
            File file=new File(rootpath+request.getPath());
            if(file.exists()){
                if(file.lastModified()<request.getTime()){
                    TransferStatus response = TransferStatus.newBuilder().setStatus(true).build();
                    responseObserver.onNext(response);
                    responseObserver.onCompleted();
                }
                else{
                    TransferStatus response = TransferStatus.newBuilder().setStatus(false).build();
                    responseObserver.onNext(response);
                    responseObserver.onCompleted();
                }
            }
            else{
                TransferStatus response = TransferStatus.newBuilder().setStatus(true).build();
                responseObserver.onNext(response);
                responseObserver.onCompleted();
            }
        }catch (Exception e){
                responseObserver.onError(e);
        }

    }
    @Override
    public void push(com.distribute.grpc.TransferResponse request,
        io.grpc.stub.StreamObserver<com.distribute.grpc.TransferRequest> responseObserver){
            
            try{
            File file=new File(rootpath+request.getPath());
            Path path = FileSystems.getDefault().getPath(rootpath+request.getPath());
            Files.createDirectories(path.getParent());
            RandomAccessFile fileaccess=new RandomAccessFile(file,"rw");
            FileChannel channel = fileaccess.getChannel();
            ByteBuffer buffer = ByteBuffer.wrap(request.getContent().toByteArray());
            channel.truncate(0);
            channel.write(buffer);
            channel.close();
            TransferRequest response = TransferRequest.newBuilder().setPath(request.getPath()).build();
            responseObserver.onNext(response);
            responseObserver.onCompleted();

            } catch (Exception e) {
                e.printStackTrace();
                responseObserver.onError(e);
            }

        }

    @Override
    public void delete(com.distribute.grpc.TransferRequest request,
                       io.grpc.stub.StreamObserver<com.distribute.grpc.TransferStatus> responseObserver){
        try{
            File file=new File(rootpath+request.getPath());

            boolean result= file.delete();
            TransferStatus response = TransferStatus.newBuilder().setStatus(result).build();
            responseObserver.onNext(response);
            responseObserver.onCompleted();

        } catch (Exception e) {
            e.printStackTrace();
            responseObserver.onError(e);
        }
    }
}
