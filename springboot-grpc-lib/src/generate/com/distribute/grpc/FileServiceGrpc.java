package com.distribute.grpc;

import static io.grpc.MethodDescriptor.generateFullMethodName;
import static io.grpc.stub.ClientCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ClientCalls.asyncClientStreamingCall;
import static io.grpc.stub.ClientCalls.asyncServerStreamingCall;
import static io.grpc.stub.ClientCalls.asyncUnaryCall;
import static io.grpc.stub.ClientCalls.blockingServerStreamingCall;
import static io.grpc.stub.ClientCalls.blockingUnaryCall;
import static io.grpc.stub.ClientCalls.futureUnaryCall;
import static io.grpc.stub.ServerCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ServerCalls.asyncClientStreamingCall;
import static io.grpc.stub.ServerCalls.asyncServerStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnaryCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.26.0)",
    comments = "Source: file.proto")
public final class FileServiceGrpc {

  private FileServiceGrpc() {}

  public static final String SERVICE_NAME = "FileService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<com.distribute.grpc.FileRequest,
      com.distribute.grpc.FileResponse> getUploadMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "Upload",
      requestType = com.distribute.grpc.FileRequest.class,
      responseType = com.distribute.grpc.FileResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.distribute.grpc.FileRequest,
      com.distribute.grpc.FileResponse> getUploadMethod() {
    io.grpc.MethodDescriptor<com.distribute.grpc.FileRequest, com.distribute.grpc.FileResponse> getUploadMethod;
    if ((getUploadMethod = FileServiceGrpc.getUploadMethod) == null) {
      synchronized (FileServiceGrpc.class) {
        if ((getUploadMethod = FileServiceGrpc.getUploadMethod) == null) {
          FileServiceGrpc.getUploadMethod = getUploadMethod =
              io.grpc.MethodDescriptor.<com.distribute.grpc.FileRequest, com.distribute.grpc.FileResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "Upload"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.distribute.grpc.FileRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.distribute.grpc.FileResponse.getDefaultInstance()))
              .setSchemaDescriptor(new FileServiceMethodDescriptorSupplier("Upload"))
              .build();
        }
      }
    }
    return getUploadMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.distribute.grpc.FileRequestBrif,
      com.distribute.grpc.FileResponse> getDownloadMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "Download",
      requestType = com.distribute.grpc.FileRequestBrif.class,
      responseType = com.distribute.grpc.FileResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.distribute.grpc.FileRequestBrif,
      com.distribute.grpc.FileResponse> getDownloadMethod() {
    io.grpc.MethodDescriptor<com.distribute.grpc.FileRequestBrif, com.distribute.grpc.FileResponse> getDownloadMethod;
    if ((getDownloadMethod = FileServiceGrpc.getDownloadMethod) == null) {
      synchronized (FileServiceGrpc.class) {
        if ((getDownloadMethod = FileServiceGrpc.getDownloadMethod) == null) {
          FileServiceGrpc.getDownloadMethod = getDownloadMethod =
              io.grpc.MethodDescriptor.<com.distribute.grpc.FileRequestBrif, com.distribute.grpc.FileResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "Download"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.distribute.grpc.FileRequestBrif.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.distribute.grpc.FileResponse.getDefaultInstance()))
              .setSchemaDescriptor(new FileServiceMethodDescriptorSupplier("Download"))
              .build();
        }
      }
    }
    return getDownloadMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.distribute.grpc.FileRequest,
      com.distribute.grpc.FileResponse> getUpdateMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "Update",
      requestType = com.distribute.grpc.FileRequest.class,
      responseType = com.distribute.grpc.FileResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.distribute.grpc.FileRequest,
      com.distribute.grpc.FileResponse> getUpdateMethod() {
    io.grpc.MethodDescriptor<com.distribute.grpc.FileRequest, com.distribute.grpc.FileResponse> getUpdateMethod;
    if ((getUpdateMethod = FileServiceGrpc.getUpdateMethod) == null) {
      synchronized (FileServiceGrpc.class) {
        if ((getUpdateMethod = FileServiceGrpc.getUpdateMethod) == null) {
          FileServiceGrpc.getUpdateMethod = getUpdateMethod =
              io.grpc.MethodDescriptor.<com.distribute.grpc.FileRequest, com.distribute.grpc.FileResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "Update"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.distribute.grpc.FileRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.distribute.grpc.FileResponse.getDefaultInstance()))
              .setSchemaDescriptor(new FileServiceMethodDescriptorSupplier("Update"))
              .build();
        }
      }
    }
    return getUpdateMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.distribute.grpc.FileRequestBrif,
      com.distribute.grpc.FileResponse> getDeleteMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "Delete",
      requestType = com.distribute.grpc.FileRequestBrif.class,
      responseType = com.distribute.grpc.FileResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.distribute.grpc.FileRequestBrif,
      com.distribute.grpc.FileResponse> getDeleteMethod() {
    io.grpc.MethodDescriptor<com.distribute.grpc.FileRequestBrif, com.distribute.grpc.FileResponse> getDeleteMethod;
    if ((getDeleteMethod = FileServiceGrpc.getDeleteMethod) == null) {
      synchronized (FileServiceGrpc.class) {
        if ((getDeleteMethod = FileServiceGrpc.getDeleteMethod) == null) {
          FileServiceGrpc.getDeleteMethod = getDeleteMethod =
              io.grpc.MethodDescriptor.<com.distribute.grpc.FileRequestBrif, com.distribute.grpc.FileResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "Delete"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.distribute.grpc.FileRequestBrif.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.distribute.grpc.FileResponse.getDefaultInstance()))
              .setSchemaDescriptor(new FileServiceMethodDescriptorSupplier("Delete"))
              .build();
        }
      }
    }
    return getDeleteMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.distribute.grpc.FileRequestBrif,
      com.distribute.grpc.FileResponse> getCommitMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "Commit",
      requestType = com.distribute.grpc.FileRequestBrif.class,
      responseType = com.distribute.grpc.FileResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.distribute.grpc.FileRequestBrif,
      com.distribute.grpc.FileResponse> getCommitMethod() {
    io.grpc.MethodDescriptor<com.distribute.grpc.FileRequestBrif, com.distribute.grpc.FileResponse> getCommitMethod;
    if ((getCommitMethod = FileServiceGrpc.getCommitMethod) == null) {
      synchronized (FileServiceGrpc.class) {
        if ((getCommitMethod = FileServiceGrpc.getCommitMethod) == null) {
          FileServiceGrpc.getCommitMethod = getCommitMethod =
              io.grpc.MethodDescriptor.<com.distribute.grpc.FileRequestBrif, com.distribute.grpc.FileResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "Commit"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.distribute.grpc.FileRequestBrif.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.distribute.grpc.FileResponse.getDefaultInstance()))
              .setSchemaDescriptor(new FileServiceMethodDescriptorSupplier("Commit"))
              .build();
        }
      }
    }
    return getCommitMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static FileServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<FileServiceStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<FileServiceStub>() {
        @java.lang.Override
        public FileServiceStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new FileServiceStub(channel, callOptions);
        }
      };
    return FileServiceStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static FileServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<FileServiceBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<FileServiceBlockingStub>() {
        @java.lang.Override
        public FileServiceBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new FileServiceBlockingStub(channel, callOptions);
        }
      };
    return FileServiceBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static FileServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<FileServiceFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<FileServiceFutureStub>() {
        @java.lang.Override
        public FileServiceFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new FileServiceFutureStub(channel, callOptions);
        }
      };
    return FileServiceFutureStub.newStub(factory, channel);
  }

  /**
   */
  public static abstract class FileServiceImplBase implements io.grpc.BindableService {

    /**
     * <pre>
     *from the view of client
     * </pre>
     */
    public void upload(com.distribute.grpc.FileRequest request,
        io.grpc.stub.StreamObserver<com.distribute.grpc.FileResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getUploadMethod(), responseObserver);
    }

    /**
     */
    public void download(com.distribute.grpc.FileRequestBrif request,
        io.grpc.stub.StreamObserver<com.distribute.grpc.FileResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getDownloadMethod(), responseObserver);
    }

    /**
     */
    public void update(com.distribute.grpc.FileRequest request,
        io.grpc.stub.StreamObserver<com.distribute.grpc.FileResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getUpdateMethod(), responseObserver);
    }

    /**
     */
    public void delete(com.distribute.grpc.FileRequestBrif request,
        io.grpc.stub.StreamObserver<com.distribute.grpc.FileResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getDeleteMethod(), responseObserver);
    }

    /**
     */
    public void commit(com.distribute.grpc.FileRequestBrif request,
        io.grpc.stub.StreamObserver<com.distribute.grpc.FileResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getCommitMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getUploadMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                com.distribute.grpc.FileRequest,
                com.distribute.grpc.FileResponse>(
                  this, METHODID_UPLOAD)))
          .addMethod(
            getDownloadMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                com.distribute.grpc.FileRequestBrif,
                com.distribute.grpc.FileResponse>(
                  this, METHODID_DOWNLOAD)))
          .addMethod(
            getUpdateMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                com.distribute.grpc.FileRequest,
                com.distribute.grpc.FileResponse>(
                  this, METHODID_UPDATE)))
          .addMethod(
            getDeleteMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                com.distribute.grpc.FileRequestBrif,
                com.distribute.grpc.FileResponse>(
                  this, METHODID_DELETE)))
          .addMethod(
            getCommitMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                com.distribute.grpc.FileRequestBrif,
                com.distribute.grpc.FileResponse>(
                  this, METHODID_COMMIT)))
          .build();
    }
  }

  /**
   */
  public static final class FileServiceStub extends io.grpc.stub.AbstractAsyncStub<FileServiceStub> {
    private FileServiceStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected FileServiceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new FileServiceStub(channel, callOptions);
    }

    /**
     * <pre>
     *from the view of client
     * </pre>
     */
    public void upload(com.distribute.grpc.FileRequest request,
        io.grpc.stub.StreamObserver<com.distribute.grpc.FileResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getUploadMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void download(com.distribute.grpc.FileRequestBrif request,
        io.grpc.stub.StreamObserver<com.distribute.grpc.FileResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getDownloadMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void update(com.distribute.grpc.FileRequest request,
        io.grpc.stub.StreamObserver<com.distribute.grpc.FileResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getUpdateMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void delete(com.distribute.grpc.FileRequestBrif request,
        io.grpc.stub.StreamObserver<com.distribute.grpc.FileResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getDeleteMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void commit(com.distribute.grpc.FileRequestBrif request,
        io.grpc.stub.StreamObserver<com.distribute.grpc.FileResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getCommitMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class FileServiceBlockingStub extends io.grpc.stub.AbstractBlockingStub<FileServiceBlockingStub> {
    private FileServiceBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected FileServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new FileServiceBlockingStub(channel, callOptions);
    }

    /**
     * <pre>
     *from the view of client
     * </pre>
     */
    public com.distribute.grpc.FileResponse upload(com.distribute.grpc.FileRequest request) {
      return blockingUnaryCall(
          getChannel(), getUploadMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.distribute.grpc.FileResponse download(com.distribute.grpc.FileRequestBrif request) {
      return blockingUnaryCall(
          getChannel(), getDownloadMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.distribute.grpc.FileResponse update(com.distribute.grpc.FileRequest request) {
      return blockingUnaryCall(
          getChannel(), getUpdateMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.distribute.grpc.FileResponse delete(com.distribute.grpc.FileRequestBrif request) {
      return blockingUnaryCall(
          getChannel(), getDeleteMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.distribute.grpc.FileResponse commit(com.distribute.grpc.FileRequestBrif request) {
      return blockingUnaryCall(
          getChannel(), getCommitMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class FileServiceFutureStub extends io.grpc.stub.AbstractFutureStub<FileServiceFutureStub> {
    private FileServiceFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected FileServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new FileServiceFutureStub(channel, callOptions);
    }

    /**
     * <pre>
     *from the view of client
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.distribute.grpc.FileResponse> upload(
        com.distribute.grpc.FileRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getUploadMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.distribute.grpc.FileResponse> download(
        com.distribute.grpc.FileRequestBrif request) {
      return futureUnaryCall(
          getChannel().newCall(getDownloadMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.distribute.grpc.FileResponse> update(
        com.distribute.grpc.FileRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getUpdateMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.distribute.grpc.FileResponse> delete(
        com.distribute.grpc.FileRequestBrif request) {
      return futureUnaryCall(
          getChannel().newCall(getDeleteMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.distribute.grpc.FileResponse> commit(
        com.distribute.grpc.FileRequestBrif request) {
      return futureUnaryCall(
          getChannel().newCall(getCommitMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_UPLOAD = 0;
  private static final int METHODID_DOWNLOAD = 1;
  private static final int METHODID_UPDATE = 2;
  private static final int METHODID_DELETE = 3;
  private static final int METHODID_COMMIT = 4;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final FileServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(FileServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_UPLOAD:
          serviceImpl.upload((com.distribute.grpc.FileRequest) request,
              (io.grpc.stub.StreamObserver<com.distribute.grpc.FileResponse>) responseObserver);
          break;
        case METHODID_DOWNLOAD:
          serviceImpl.download((com.distribute.grpc.FileRequestBrif) request,
              (io.grpc.stub.StreamObserver<com.distribute.grpc.FileResponse>) responseObserver);
          break;
        case METHODID_UPDATE:
          serviceImpl.update((com.distribute.grpc.FileRequest) request,
              (io.grpc.stub.StreamObserver<com.distribute.grpc.FileResponse>) responseObserver);
          break;
        case METHODID_DELETE:
          serviceImpl.delete((com.distribute.grpc.FileRequestBrif) request,
              (io.grpc.stub.StreamObserver<com.distribute.grpc.FileResponse>) responseObserver);
          break;
        case METHODID_COMMIT:
          serviceImpl.commit((com.distribute.grpc.FileRequestBrif) request,
              (io.grpc.stub.StreamObserver<com.distribute.grpc.FileResponse>) responseObserver);
          break;
        default:
          throw new AssertionError();
      }
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public io.grpc.stub.StreamObserver<Req> invoke(
        io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        default:
          throw new AssertionError();
      }
    }
  }

  private static abstract class FileServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    FileServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.distribute.grpc.fileInt.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("FileService");
    }
  }

  private static final class FileServiceFileDescriptorSupplier
      extends FileServiceBaseDescriptorSupplier {
    FileServiceFileDescriptorSupplier() {}
  }

  private static final class FileServiceMethodDescriptorSupplier
      extends FileServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    FileServiceMethodDescriptorSupplier(String methodName) {
      this.methodName = methodName;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.MethodDescriptor getMethodDescriptor() {
      return getServiceDescriptor().findMethodByName(methodName);
    }
  }

  private static volatile io.grpc.ServiceDescriptor serviceDescriptor;

  public static io.grpc.ServiceDescriptor getServiceDescriptor() {
    io.grpc.ServiceDescriptor result = serviceDescriptor;
    if (result == null) {
      synchronized (FileServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new FileServiceFileDescriptorSupplier())
              .addMethod(getUploadMethod())
              .addMethod(getDownloadMethod())
              .addMethod(getUpdateMethod())
              .addMethod(getDeleteMethod())
              .addMethod(getCommitMethod())
              .build();
        }
      }
    }
    return result;
  }
}
