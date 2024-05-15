package com.distribute.service.updateList;


import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.Queue;

import static com.distribute.service.myClass.MetaData.rootPath;

@Component
@Scope("singleton")
public class UpdateList {
   Queue<String> updateQueue;

   public UpdateList() throws FileNotFoundException{
       this.updateQueue=new LinkedList<>();
       File root=new File(rootPath);
       readFolderNameRecursive(root);
   }

    public synchronized void enqueue(String element) {
        updateQueue.offer(element);
    }

    // 从队列中取出元素
    public synchronized String dequeue() {
        if (!updateQueue.isEmpty()) {
            return updateQueue.poll();
        }
        return null;
    }

    public boolean isEmpty(){
       return updateQueue.isEmpty();
    }
    private void readFolderNameRecursive(File folder) throws FileNotFoundException {
        File[] files=folder.listFiles();

        if(files!=null){
            for(File file:files){
                if(file.isDirectory()){
                    readFolderNameRecursive(file);
                }
                else{
                    updateQueue.add(file.getAbsolutePath().replace("\\","/").substring(rootPath.length()));
                }
            }
        }
    }

}
