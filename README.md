```
FileSystem
├─backup-service                                     # 备份服务                             
│  └─src/main
│         └─java/com/distribute/backup
│                                ├─config            #设置暴露RPC服务的端口
│                                └─service
|                                   └─BackUpService  #实现备份的RPC服务
├─client                                          #用户端
│  └─src
│     └─main
│         └─java/com/distribute/client
|                       ├─ClientInterface         #用户的命令行接口
|                       ├─Config                  #设置客户端stub与服务器对接的端口
│                       └─request   
|                           ├─FileRequest         #用于文件增删查改的请求
|                           └─DirectoryRequest    #用于获取文件夹的信息，实现cd，ls和mkdir
├─service                                           #主服务器
│  └─src/main
│         └─java
│            └─com/distribute/service
│                        ├─Config                   #设置作为服务器暴露RPC的端口与作为客户调用备份服务的端口
│                        ├─exception                #一些自定义的异常类型
│                        ├─lock
|                        |  └─LockTree              #维护一棵目录树，从每个节点负责写入文件和上锁
│                        ├─myClass                  #一些需要的类
|                        |  ├─MetaData              #重要的共享数据
|                        |  └─treeNode              #定义的目录树节点
│                        ├─service
|                        |  ├─DirectoryService      #执行用户目录操作的RPC服务
|                        |  └─FileService           #执行文件增删查改的RPC服务
│                        ├─updateList               #一个队列，用于存储更新的文件数据并把队列中的文件向备份服务器同步
|                        └─BackupDaemon             #一个守护程序，用于每20秒清空更新队列向备份服务器同步
|                       
├─springboot-grpc-lib      # GRPC的接口
│  └─src
│     ├─generate
│     │  └─com/distribute
│     │          └─grpc    #编译出来的 gRPC类
│     └─proto              # proto文件，定义RPC服务样式
```