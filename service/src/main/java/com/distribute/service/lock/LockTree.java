package com.distribute.service.lock;

import com.distribute.service.exception.FileNotFound;
import com.distribute.service.myClass.treeNode;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.FileNotFoundException;

import static com.distribute.service.myClass.MetaData.rootPath;

@Component
@Scope("singleton")
public class LockTree {
    
    treeNode dirTree;

    public LockTree() throws FileNotFoundException {

         File root=new File(rootPath);
         this.dirTree=new treeNode(root);
         readFolderNameRecursive(root,dirTree);
     }

    public treeNode findNode(String path) {
        if (path == null ) {
            return null;
        }

        if(path.isEmpty()){
            return dirTree;
        }
        // 将路径分割成各个部分
        String[] pathParts = path.split("/");
        treeNode current=dirTree;
        for(String dir:pathParts){
            treeNode parent=current;
            for (treeNode child : current.getChildren()) {
                if (child.getNodeName().equals(dir)) {
                    current=child;
                    break;
                }
            }
            if(current.getNodeName().equals(parent.getNodeName())){
                throw new FileNotFound("请检查目录");
            }
        }
        return current;
    }

    //用于插入单个文件
    public boolean insert(String parentpath,String path,boolean type) throws FileNotFoundException{
        treeNode parent=findNode(parentpath);
        for(treeNode child:parent.getChildren()){
            if(child.getNodeName().equals(path)){
                return false;
            }
        }
        File fs=new File(rootPath+parentpath+path);
        parent.getChildren().add(new treeNode(fs,type));
        return true;
    }

    public boolean delete(String parentpath,String path){
        treeNode parent=findNode(parentpath);
        for(treeNode child:parent.getChildren()){
            if(child.getNodeName().equals(path)){
                parent.getChildren().remove(child);
                return true;
            }
        }
        return false;
    }
     private void readFolderNameRecursive(File folder,treeNode node) throws FileNotFoundException{
         File[] files=folder.listFiles();

         if(files!=null){
             for(File file:files){
                 if(file.isDirectory()){
                     treeNode subDir=new treeNode(file);
                     node.getChildren().add(subDir);
                     readFolderNameRecursive(file, subDir);
                 }
                 else{
                     treeNode filename=new treeNode(file);
                     node.getChildren().add(filename);
                 }
             }
         }
     }
}
