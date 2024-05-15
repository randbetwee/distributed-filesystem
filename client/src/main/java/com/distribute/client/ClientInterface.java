package com.distribute.client;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

import com.distribute.client.request.DirectoryRequest;
import io.grpc.StatusException;
import io.grpc.StatusRuntimeException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.distribute.client.request.FileClient;

@Component
public class ClientInterface implements CommandLineRunner {

    private final FileClient fileServiceClient;
    private final DirectoryRequest directoryRequest;
    private final Scanner scanner;

    private String currentPath="";

    @Autowired
    public ClientInterface(FileClient fileServiceClient,DirectoryRequest dir) {
        this.fileServiceClient = fileServiceClient;
        this.directoryRequest= dir;
        this.scanner = new Scanner(System.in);
    }

    @Override
    public void run(String... args) throws Exception {
        while (true) {
            System.out.print(currentPath+">");
            String command = getUserChoice();

            String[] commandParts = command.split("\\s+");
            String action = commandParts[0].toLowerCase();
            switch (action) {
                case "create":
                    if (commandParts.length > 1) {
                        String fileName = commandParts[1];
                        uploadFile(fileName);
                    } else {
                        System.out.println("Invalid edit command. Please provide a file name.");
                    }
                    break;
                case "read":
                    if (commandParts.length > 1) {
                        String fileName = commandParts[1];
                        Read(fileName);
                    } else {
                        System.out.println("Invalid edit command. Please provide a file name.");
                    }
                    break;
                case "edit":
                    if (commandParts.length > 1) {
                        String fileName = commandParts[1];
                        edit(fileName);
                    } else {
                        System.out.println("Invalid edit command. Please provide a file name.");
                    }
                    break;
                case "delete":
                    if (commandParts.length > 1) {
                        String fileName = commandParts[1];
                        deleteFile(fileName);
                    } else {
                        System.out.println("Invalid edit command. Please provide a file name.");
                    }
                    break;
                case "ls":
                    if (commandParts.length == 1) {
                        ls();
                    } else {
                        System.out.println("Invalid ls command.");
                    }
                    break;
                case "cd":       //请一级一级进入
                    if(commandParts.length > 1) {
                        String path = commandParts[1];
                        if(path.equals("..")){
                            Path p=Paths.get(currentPath).getParent();
                            if(p==null)
                                currentPath="";
                            else
                                currentPath=p.toString().replace('\\', '/');
                        }
                        else{
                            if(cd(currentPath+path))
                                if(currentPath.isEmpty())
                                currentPath=path;
                                else
                                currentPath=currentPath +'/'+ path;
                            else
                                System.out.println("not directory");
                        }
                    } else {
                        System.out.println("Invalid ls command. Please provide a path.");
                    }
                    break;
                case "mkdir":
                    if (commandParts.length > 1) {
                        String directoryName = commandParts[1];
                        mkdir(currentPath+'/'+directoryName);
                    } else {
                        System.out.println("Invalid mkdir command. Please provide a directory name.");
                    }
                    break;
                case "exit":
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }


    private void mkdir(String directoryName) {
        try {
        directoryRequest.mkdir(directoryName);
        }catch (Exception e){
        System.out.println("Exception unknown");
        }
    }

    private boolean cd(String path){
        try{
            return directoryRequest.cd(path);
        }catch (Exception e){
            return false;
        }
    }

    private void displayMenu() {
        System.out.println("1. Upload File");
        System.out.println("2. Download File");
        System.out.println("3. Update File");
        System.out.println("4. Delete File");
        System.out.println("5. Exit");
        System.out.print("Enter your choice: ");
    }

    private String getUserChoice() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

    private void uploadFile(String filename) {
        try{
            Path p=Paths.get(filename);
            byte[] content = Files.readAllBytes(p);
            fileServiceClient.upload(filename, content);
            System.out.println("File uploaded successfully.");
        }
        catch(IOException|StatusRuntimeException e){
            System.out.println("打开文件失败");
        }

    }

    private void ls(){
        directoryRequest.Ls(currentPath);
    }
    private void Read(String fileName) {


        try {
            fileServiceClient.download(fileName);
            ProcessBuilder processBuilder = new ProcessBuilder("notepad.exe", fileName);
            // 启动外部命令
            Process process = processBuilder.start();

            // 等待外部命令执行完毕
            int exitCode = process.waitFor();

            // 检查返回值
            if (exitCode == 0) {
                System.out.println("文本编辑器已关闭");
            } else {
                System.out.println("外部命令执行失败！");
            }
        } catch (IOException | InterruptedException | StatusRuntimeException e) {
            if(e instanceof StatusRuntimeException)
                System.out.println("该资源正在访问请稍后重试");
            //e.printStackTrace();
        }
        fileServiceClient.commit(fileName);

    }

    private void edit(String fileName) {
        fileServiceClient.download(fileName);
        ProcessBuilder processBuilder = new ProcessBuilder("notepad.exe", fileName);

        try {
            // 启动外部命令
            Process process = processBuilder.start();

            // 等待外部命令执行完毕
            int exitCode = process.waitFor();

            // 检查返回值
            if (exitCode == 0) {
                System.out.println("文本编辑器已关闭");
            } else {
                System.out.println("外部命令执行失败！");
            }


            byte[] content = Files.readAllBytes(Paths.get(fileName));

            fileServiceClient.update(fileName, content);
            fileServiceClient.commit(fileName);
            System.out.println("File updated successfully.");
        }
        catch(IOException | InterruptedException |StatusRuntimeException e){
            if(e instanceof StatusRuntimeException)
                System.out.println("该资源正在访问请稍后重试");
            System.out.println("打开文件失败");
        }
    }

    private void deleteFile(String fileName) {
        try {
            fileServiceClient.delete(fileName);
            System.out.println("File deleted successfully.");
        }catch (StatusRuntimeException e){
            if(e instanceof StatusRuntimeException)
                System.out.println("该资源正在访问请稍后重试");
        }
    }
}
