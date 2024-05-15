package com.distribute.service.service;

import com.distribute.grpc.DirectoryServiceGrpc;
import com.distribute.grpc.LsResponse;
import com.distribute.grpc.MkdirResponse;
import com.distribute.service.exception.FileNotFound;
import com.distribute.service.lock.LockTree;
import com.distribute.service.myClass.treeNode;
import net.devh.boot.grpc.server.service.GrpcService;
import org.springframework.beans.factory.annotation.Autowired;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

import static com.distribute.service.myClass.MetaData.rootPath;

// import com.DistriFileSys.server.myClass.treeNode;

@GrpcService
public class DirectoryService extends DirectoryServiceGrpc.DirectoryServiceImplBase  {

    @Autowired
    LockTree dirTree;
    @Override
    public void ls(com.distribute.grpc.LsRequest request,
                   io.grpc.stub.StreamObserver<com.distribute.grpc.LsResponse> responseObserver){
        String path = request.getPath();

        File current=new File(rootPath+path);
        if(!current.isDirectory())
            responseObserver.onError(new FileNotFound("该路径不是文件夹"));

        File[] files=current.listFiles();
        List<String> filename=new ArrayList<>();
        if(files!=null){
            for(File file:files){
                filename.add(file.getName());
            }
        }
        LsResponse response = LsResponse.newBuilder().addAllFilenames(filename).build();
        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }

    //request第一个字母不可以有/
    @Override
    public void mkdir(com.distribute.grpc.LsRequest request,
                      io.grpc.stub.StreamObserver<com.distribute.grpc.MkdirResponse> responseObserver){

        try{
            treeNode current=dirTree.findNode("");
            String[] pathParts = request.getPath().split("/");
            String currentpath="";
            for(String filename:pathParts){
                    treeNode parent=current;
                    for (treeNode child : current.getChildren()) {
                        if (child.getNodeName().equals(filename)) {
                            current=child;
                            break;
                        }

                    }
                if(!current.getNodeName().equals(parent.getNodeName())){
                    File file=new File(rootPath+currentpath+current.getNodeName());
                    if(!file.isDirectory()){
                        throw new FileNotFound("文件路径中存在非文件夹或名字已被文件占用");
                    }
                }
                else{
                    dirTree.insert(currentpath,filename,false);
                }
                currentpath=currentpath+filename;
            }

            File dir=new File(rootPath+request.getPath());
            boolean end=dir.mkdirs();
            MkdirResponse response = MkdirResponse.newBuilder().setStatus(true).build();
            responseObserver.onNext(response);
            responseObserver.onCompleted();
        }catch(SecurityException | FileNotFoundException e){
            e.printStackTrace();
            responseObserver.onError(e);
        }
    }


    @Override
    public void cd(com.distribute.grpc.LsRequest request,
                   io.grpc.stub.StreamObserver<com.distribute.grpc.MkdirResponse> responseObserver){
        String path= request.getPath();
        File file=new File(rootPath+path);
        if(file.isDirectory()){
            MkdirResponse response = MkdirResponse.newBuilder().setStatus(true).build();
            responseObserver.onNext(response);
            responseObserver.onCompleted();
        }
        else {
            MkdirResponse response = MkdirResponse.newBuilder().setStatus(false).build();
            responseObserver.onNext(response);
            responseObserver.onCompleted();
        }

    }
}
