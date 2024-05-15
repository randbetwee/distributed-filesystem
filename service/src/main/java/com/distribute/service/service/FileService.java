package com.distribute.service.service;

import  com.distribute.grpc.FileRequest;
import  com.distribute.grpc.FileRequestBrif;
import  com.distribute.grpc.FileResponse;
import  com.distribute.grpc.FileServiceGrpc;
import com.distribute.service.exception.FileNotFound;
import com.distribute.service.exception.ServiceException;
import com.distribute.service.lock.LockTree;
import com.distribute.service.myClass.treeNode;
import com.distribute.service.updateList.UpdateList;
import com.google.protobuf.ByteString;
import io.grpc.stub.StreamObserver;
import net.devh.boot.grpc.server.service.GrpcService;
import org.springframework.beans.factory.annotation.Autowired;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;
import java.nio.channels.OverlappingFileLockException;
import java.nio.file.Path;
import java.nio.file.Paths;
import static com.distribute.service.myClass.MetaData.rootPath;


@GrpcService
public class FileService extends FileServiceGrpc.FileServiceImplBase {

    @Autowired
    LockTree dirTree;

    @Autowired
    UpdateList updateList;

    @Override
    public void upload(FileRequest request, StreamObserver<FileResponse> responseObserver) {
        //request 包含String path 和bytes content  path第一个字符不包含/
        String path=request.getFileName();
        String file=Paths.get(path).getFileName().toString();
        Path parent= Paths.get(path).getParent();
        String parentpath=null;
        if(parent==null)
            parentpath="";
        else
            parentpath=parent.toString();
        try{
            if(!dirTree.insert(parentpath,file,true))
                throw new FileNotFound("文件已存在"); }catch(FileNotFoundException e){throw new ServiceException("插入失败");}
        treeNode fileNode=dirTree.findNode(path);
        FileChannel channel=fileNode.getFile().getChannel();
        FileLock lock=null;

        try{
            lock=channel.tryLock();
            ByteBuffer buffer = ByteBuffer.wrap(request.getContent().toByteArray());
            channel.position(0);
            channel.write(buffer);
            updateList.enqueue(path);
            lock.release();
            byte[] inform="upload completed".getBytes();
            FileResponse response = FileResponse.newBuilder().setContent(ByteString.copyFrom(inform)).build();
            responseObserver.onNext(response);
            responseObserver.onCompleted();
        } catch (IOException | OverlappingFileLockException e) {
            if (lock != null) {
                try {
                    lock.release();
                } catch (IOException | NullPointerException ex) {
                    responseObserver.onError(ex);
                }
            e.printStackTrace();
            responseObserver.onError(e);
        }
        }
    }

    @Override
    public void download(FileRequestBrif request, StreamObserver<FileResponse> responseObserver) {
        String fileName = request.getFileName();
        treeNode fileNode=dirTree.findNode(fileName);
        FileChannel channel=fileNode.getFile().getChannel();
        FileLock lock=null;
        try {


            lock=channel.tryLock();
            fileNode.setLock(lock);
            channel.position(0);
            ByteBuffer buffer = ByteBuffer.allocate((int) channel.size());
            channel.read(buffer);
            byte[] content= buffer.array();

            // 创建响应消息，包含文件内容
            FileResponse response = FileResponse.newBuilder()
                    .setContent(ByteString.copyFrom(content))
                    .build();

            responseObserver.onNext(response);
            responseObserver.onCompleted();
        } catch (IOException | OverlappingFileLockException e) {
            if(lock!=null) {
                try {
                    lock.release();
                } catch (IOException | NullPointerException ex) {
                    responseObserver.onError(ex);
                }
            }
            ;
            e.printStackTrace();
            responseObserver.onError(e);
        }
    }

    @Override
    public void delete(FileRequestBrif request, StreamObserver<FileResponse> responseObserver){
        String fileName = request.getFileName();

        String file=Paths.get(fileName).getFileName().toString();
        Path parent= Paths.get(fileName).getParent();
        String parentpath=null;
        if(parent==null)
            parentpath="";
        else
            parentpath=parent.toString();
        treeNode node=dirTree.findNode(fileName);
        FileChannel channel=node.getFile().getChannel();
        FileLock lock=null;

        try {
            lock = channel.tryLock();
            channel.close();
            dirTree.delete(parentpath, file);
            File fileToDelete = new File(rootPath + fileName);
            if (fileToDelete.delete()) {

                byte[] inform = "delete completed".getBytes();
                updateList.enqueue(fileName);
                FileResponse response = FileResponse.newBuilder().setContent(ByteString.copyFrom(inform)).build();
                responseObserver.onNext(response);
                responseObserver.onCompleted();
            } else {
                if(lock!=null)
                        lock.release();
                responseObserver.onError(new RuntimeException("Failed to delete file: " + fileName));
            }
        }catch (IOException|OverlappingFileLockException e){
            responseObserver.onError(new RuntimeException("Failed to delete file: " + fileName));
        }
    }

    @Override
    public void update(FileRequest request, StreamObserver<FileResponse> responseObserver){
        String fileName = request.getFileName();
        byte[] newContent = request.getContent().toByteArray();

        treeNode fileNode=dirTree.findNode(fileName);
        FileChannel channel=fileNode.getFile().getChannel();

        try{
            ByteBuffer buffer = ByteBuffer.wrap(request.getContent().toByteArray());
            channel.truncate(0);
            channel.write(buffer);
            updateList.enqueue(fileName);
            byte[] inform="update completed".getBytes();
            FileResponse response = FileResponse.newBuilder().setContent(ByteString.copyFrom(inform)).build();
            responseObserver.onNext(response);
            responseObserver.onCompleted();
        } catch (IOException e) {
            e.printStackTrace();
            responseObserver.onError(e);
        }
    }

    @Override
    public void commit(FileRequestBrif request, StreamObserver<FileResponse> responseObserver){
        String path=request.getFileName();
        FileLock lock=dirTree.findNode(path).getLock();
        FileResponse response = FileResponse.newBuilder().setContent(ByteString.copyFrom("解锁成功".getBytes())).build();
        responseObserver.onNext(response);
        responseObserver.onCompleted();
        try {
            lock.release();
        }catch(IOException e){
            e.printStackTrace();
            responseObserver.onError(e);
        }


    }

}
