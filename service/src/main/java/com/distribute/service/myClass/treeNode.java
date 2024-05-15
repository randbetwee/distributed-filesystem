package com.distribute.service.myClass;

import lombok.Data;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.RandomAccessFile;
import java.nio.channels.FileLock;
import java.util.ArrayList;
import java.util.List;

//构建目录树
@Data
public class treeNode {
    private String nodeName;
    private RandomAccessFile file;      //文件描述符
    private FileLock lock;        //读写通道
    private List<treeNode> children;

    //1为文件，0为目录，用于创建
    public treeNode(File nodename,boolean type) throws FileNotFoundException {
        this.nodeName = nodename.getName();
        if(type){
            this.file=new RandomAccessFile(nodename,"rw");
            this.lock=null;
        }
        this.children=new ArrayList<>();
    }

    //用于扫描文档
    public treeNode(File nodename) throws FileNotFoundException {
        this.nodeName = nodename.getName();
        if(nodename.isFile()){
            this.file=new RandomAccessFile(nodename,"rw");
            this.lock=null;
        }
        this.children=new ArrayList<>();
    }

}
