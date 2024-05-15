package com.distribute.service;

import com.distribute.grpc.BackupServiceGrpc;
import com.distribute.grpc.TransferRequest;
import com.distribute.grpc.TransferResponse;
import com.distribute.grpc.TransferStatus;
import com.distribute.service.lock.LockTree;
import com.distribute.service.myClass.treeNode;
import com.distribute.service.updateList.UpdateList;
import com.google.protobuf.ByteString;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;

import java.io.File;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;
import java.nio.channels.OverlappingFileLockException;

import static com.distribute.service.myClass.MetaData.rootPath;

@Service
public class BackupDaemon implements CommandLineRunner {

    @Autowired
    UpdateList updateList;

    @Autowired
    LockTree dirTree;
    private final BackupServiceGrpc.BackupServiceBlockingStub stub;

    @Autowired
    public BackupDaemon(BackupServiceGrpc.BackupServiceBlockingStub stub) {
        this.stub = stub;
    }

    @Override
    public void run(String... args) throws Exception {
        while(true){
             //5分钟，60秒，1000毫秒
            while(!updateList.isEmpty()){
                String name= updateList.dequeue();
                File file=new File(rootPath+name);
                if(file.exists()){
                    long time= file.lastModified();
                    TransferRequest request=TransferRequest.newBuilder()
                                                .setPath(name).setTime(time).build();
                    TransferStatus status=stub.pull(request);
                    if(status.getStatus()){
                        treeNode temp=dirTree.findNode(name);
                        FileChannel channel=temp.getFile().getChannel();
                        FileLock lock=null;
                        try{
                            lock=channel.lock();
                        }catch (OverlappingFileLockException e){
                            lock=null;
                        }
                        if(lock==null){
                            updateList.enqueue(name);
                            continue;
                        }
                        channel.position(0);
                        ByteBuffer buffer = ByteBuffer.allocate((int) channel.size());
                        channel.read(buffer);
                        lock.release();
                        byte[] content= buffer.array();
                        TransferResponse pushRequest= TransferResponse.newBuilder()
                                                        .setPath(name).setContent(ByteString.copyFrom(content))
                                                            .build();
                        TransferRequest response=stub.push(pushRequest);

                    }
                }
                else {
                    TransferRequest request=TransferRequest.newBuilder().setPath(name).build();
                    TransferStatus status=stub.delete(request);
                }
            }
            Thread.sleep((20 * 1000));
        }

    }
}
