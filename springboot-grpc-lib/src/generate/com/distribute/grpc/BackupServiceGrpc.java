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
    comments = "Source: backup.proto")
public final class BackupServiceGrpc {

  private BackupServiceGrpc() {}

  public static final String SERVICE_NAME = "BackupService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<com.distribute.grpc.TransferRequest,
      com.distribute.grpc.TransferStatus> getPullMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "pull",
      requestType = com.distribute.grpc.TransferRequest.class,
      responseType = com.distribute.grpc.TransferStatus.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.distribute.grpc.TransferRequest,
      com.distribute.grpc.TransferStatus> getPullMethod() {
    io.grpc.MethodDescriptor<com.distribute.grpc.TransferRequest, com.distribute.grpc.TransferStatus> getPullMethod;
    if ((getPullMethod = BackupServiceGrpc.getPullMethod) == null) {
      synchronized (BackupServiceGrpc.class) {
        if ((getPullMethod = BackupServiceGrpc.getPullMethod) == null) {
          BackupServiceGrpc.getPullMethod = getPullMethod =
              io.grpc.MethodDescriptor.<com.distribute.grpc.TransferRequest, com.distribute.grpc.TransferStatus>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "pull"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.distribute.grpc.TransferRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.distribute.grpc.TransferStatus.getDefaultInstance()))
              .setSchemaDescriptor(new BackupServiceMethodDescriptorSupplier("pull"))
              .build();
        }
      }
    }
    return getPullMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.distribute.grpc.TransferResponse,
      com.distribute.grpc.TransferRequest> getPushMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "push",
      requestType = com.distribute.grpc.TransferResponse.class,
      responseType = com.distribute.grpc.TransferRequest.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.distribute.grpc.TransferResponse,
      com.distribute.grpc.TransferRequest> getPushMethod() {
    io.grpc.MethodDescriptor<com.distribute.grpc.TransferResponse, com.distribute.grpc.TransferRequest> getPushMethod;
    if ((getPushMethod = BackupServiceGrpc.getPushMethod) == null) {
      synchronized (BackupServiceGrpc.class) {
        if ((getPushMethod = BackupServiceGrpc.getPushMethod) == null) {
          BackupServiceGrpc.getPushMethod = getPushMethod =
              io.grpc.MethodDescriptor.<com.distribute.grpc.TransferResponse, com.distribute.grpc.TransferRequest>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "push"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.distribute.grpc.TransferResponse.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.distribute.grpc.TransferRequest.getDefaultInstance()))
              .setSchemaDescriptor(new BackupServiceMethodDescriptorSupplier("push"))
              .build();
        }
      }
    }
    return getPushMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.distribute.grpc.TransferRequest,
      com.distribute.grpc.TransferStatus> getDeleteMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "delete",
      requestType = com.distribute.grpc.TransferRequest.class,
      responseType = com.distribute.grpc.TransferStatus.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.distribute.grpc.TransferRequest,
      com.distribute.grpc.TransferStatus> getDeleteMethod() {
    io.grpc.MethodDescriptor<com.distribute.grpc.TransferRequest, com.distribute.grpc.TransferStatus> getDeleteMethod;
    if ((getDeleteMethod = BackupServiceGrpc.getDeleteMethod) == null) {
      synchronized (BackupServiceGrpc.class) {
        if ((getDeleteMethod = BackupServiceGrpc.getDeleteMethod) == null) {
          BackupServiceGrpc.getDeleteMethod = getDeleteMethod =
              io.grpc.MethodDescriptor.<com.distribute.grpc.TransferRequest, com.distribute.grpc.TransferStatus>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "delete"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.distribute.grpc.TransferRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.distribute.grpc.TransferStatus.getDefaultInstance()))
              .setSchemaDescriptor(new BackupServiceMethodDescriptorSupplier("delete"))
              .build();
        }
      }
    }
    return getDeleteMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static BackupServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<BackupServiceStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<BackupServiceStub>() {
        @java.lang.Override
        public BackupServiceStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new BackupServiceStub(channel, callOptions);
        }
      };
    return BackupServiceStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static BackupServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<BackupServiceBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<BackupServiceBlockingStub>() {
        @java.lang.Override
        public BackupServiceBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new BackupServiceBlockingStub(channel, callOptions);
        }
      };
    return BackupServiceBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static BackupServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<BackupServiceFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<BackupServiceFutureStub>() {
        @java.lang.Override
        public BackupServiceFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new BackupServiceFutureStub(channel, callOptions);
        }
      };
    return BackupServiceFutureStub.newStub(factory, channel);
  }

  /**
   */
  public static abstract class BackupServiceImplBase implements io.grpc.BindableService {

    /**
     */
    public void pull(com.distribute.grpc.TransferRequest request,
        io.grpc.stub.StreamObserver<com.distribute.grpc.TransferStatus> responseObserver) {
      asyncUnimplementedUnaryCall(getPullMethod(), responseObserver);
    }

    /**
     */
    public void push(com.distribute.grpc.TransferResponse request,
        io.grpc.stub.StreamObserver<com.distribute.grpc.TransferRequest> responseObserver) {
      asyncUnimplementedUnaryCall(getPushMethod(), responseObserver);
    }

    /**
     */
    public void delete(com.distribute.grpc.TransferRequest request,
        io.grpc.stub.StreamObserver<com.distribute.grpc.TransferStatus> responseObserver) {
      asyncUnimplementedUnaryCall(getDeleteMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getPullMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                com.distribute.grpc.TransferRequest,
                com.distribute.grpc.TransferStatus>(
                  this, METHODID_PULL)))
          .addMethod(
            getPushMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                com.distribute.grpc.TransferResponse,
                com.distribute.grpc.TransferRequest>(
                  this, METHODID_PUSH)))
          .addMethod(
            getDeleteMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                com.distribute.grpc.TransferRequest,
                com.distribute.grpc.TransferStatus>(
                  this, METHODID_DELETE)))
          .build();
    }
  }

  /**
   */
  public static final class BackupServiceStub extends io.grpc.stub.AbstractAsyncStub<BackupServiceStub> {
    private BackupServiceStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected BackupServiceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new BackupServiceStub(channel, callOptions);
    }

    /**
     */
    public void pull(com.distribute.grpc.TransferRequest request,
        io.grpc.stub.StreamObserver<com.distribute.grpc.TransferStatus> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getPullMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void push(com.distribute.grpc.TransferResponse request,
        io.grpc.stub.StreamObserver<com.distribute.grpc.TransferRequest> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getPushMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void delete(com.distribute.grpc.TransferRequest request,
        io.grpc.stub.StreamObserver<com.distribute.grpc.TransferStatus> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getDeleteMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class BackupServiceBlockingStub extends io.grpc.stub.AbstractBlockingStub<BackupServiceBlockingStub> {
    private BackupServiceBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected BackupServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new BackupServiceBlockingStub(channel, callOptions);
    }

    /**
     */
    public com.distribute.grpc.TransferStatus pull(com.distribute.grpc.TransferRequest request) {
      return blockingUnaryCall(
          getChannel(), getPullMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.distribute.grpc.TransferRequest push(com.distribute.grpc.TransferResponse request) {
      return blockingUnaryCall(
          getChannel(), getPushMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.distribute.grpc.TransferStatus delete(com.distribute.grpc.TransferRequest request) {
      return blockingUnaryCall(
          getChannel(), getDeleteMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class BackupServiceFutureStub extends io.grpc.stub.AbstractFutureStub<BackupServiceFutureStub> {
    private BackupServiceFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected BackupServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new BackupServiceFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.distribute.grpc.TransferStatus> pull(
        com.distribute.grpc.TransferRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getPullMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.distribute.grpc.TransferRequest> push(
        com.distribute.grpc.TransferResponse request) {
      return futureUnaryCall(
          getChannel().newCall(getPushMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.distribute.grpc.TransferStatus> delete(
        com.distribute.grpc.TransferRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getDeleteMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_PULL = 0;
  private static final int METHODID_PUSH = 1;
  private static final int METHODID_DELETE = 2;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final BackupServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(BackupServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_PULL:
          serviceImpl.pull((com.distribute.grpc.TransferRequest) request,
              (io.grpc.stub.StreamObserver<com.distribute.grpc.TransferStatus>) responseObserver);
          break;
        case METHODID_PUSH:
          serviceImpl.push((com.distribute.grpc.TransferResponse) request,
              (io.grpc.stub.StreamObserver<com.distribute.grpc.TransferRequest>) responseObserver);
          break;
        case METHODID_DELETE:
          serviceImpl.delete((com.distribute.grpc.TransferRequest) request,
              (io.grpc.stub.StreamObserver<com.distribute.grpc.TransferStatus>) responseObserver);
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

  private static abstract class BackupServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    BackupServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.distribute.grpc.BackupInt.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("BackupService");
    }
  }

  private static final class BackupServiceFileDescriptorSupplier
      extends BackupServiceBaseDescriptorSupplier {
    BackupServiceFileDescriptorSupplier() {}
  }

  private static final class BackupServiceMethodDescriptorSupplier
      extends BackupServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    BackupServiceMethodDescriptorSupplier(String methodName) {
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
      synchronized (BackupServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new BackupServiceFileDescriptorSupplier())
              .addMethod(getPullMethod())
              .addMethod(getPushMethod())
              .addMethod(getDeleteMethod())
              .build();
        }
      }
    }
    return result;
  }
}
