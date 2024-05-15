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
    comments = "Source: directory.proto")
public final class DirectoryServiceGrpc {

  private DirectoryServiceGrpc() {}

  public static final String SERVICE_NAME = "DirectoryService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<com.distribute.grpc.LsRequest,
      com.distribute.grpc.LsResponse> getLsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "Ls",
      requestType = com.distribute.grpc.LsRequest.class,
      responseType = com.distribute.grpc.LsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.distribute.grpc.LsRequest,
      com.distribute.grpc.LsResponse> getLsMethod() {
    io.grpc.MethodDescriptor<com.distribute.grpc.LsRequest, com.distribute.grpc.LsResponse> getLsMethod;
    if ((getLsMethod = DirectoryServiceGrpc.getLsMethod) == null) {
      synchronized (DirectoryServiceGrpc.class) {
        if ((getLsMethod = DirectoryServiceGrpc.getLsMethod) == null) {
          DirectoryServiceGrpc.getLsMethod = getLsMethod =
              io.grpc.MethodDescriptor.<com.distribute.grpc.LsRequest, com.distribute.grpc.LsResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "Ls"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.distribute.grpc.LsRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.distribute.grpc.LsResponse.getDefaultInstance()))
              .setSchemaDescriptor(new DirectoryServiceMethodDescriptorSupplier("Ls"))
              .build();
        }
      }
    }
    return getLsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.distribute.grpc.LsRequest,
      com.distribute.grpc.MkdirResponse> getMkdirMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "mkdir",
      requestType = com.distribute.grpc.LsRequest.class,
      responseType = com.distribute.grpc.MkdirResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.distribute.grpc.LsRequest,
      com.distribute.grpc.MkdirResponse> getMkdirMethod() {
    io.grpc.MethodDescriptor<com.distribute.grpc.LsRequest, com.distribute.grpc.MkdirResponse> getMkdirMethod;
    if ((getMkdirMethod = DirectoryServiceGrpc.getMkdirMethod) == null) {
      synchronized (DirectoryServiceGrpc.class) {
        if ((getMkdirMethod = DirectoryServiceGrpc.getMkdirMethod) == null) {
          DirectoryServiceGrpc.getMkdirMethod = getMkdirMethod =
              io.grpc.MethodDescriptor.<com.distribute.grpc.LsRequest, com.distribute.grpc.MkdirResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "mkdir"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.distribute.grpc.LsRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.distribute.grpc.MkdirResponse.getDefaultInstance()))
              .setSchemaDescriptor(new DirectoryServiceMethodDescriptorSupplier("mkdir"))
              .build();
        }
      }
    }
    return getMkdirMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.distribute.grpc.LsRequest,
      com.distribute.grpc.MkdirResponse> getCdMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "cd",
      requestType = com.distribute.grpc.LsRequest.class,
      responseType = com.distribute.grpc.MkdirResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.distribute.grpc.LsRequest,
      com.distribute.grpc.MkdirResponse> getCdMethod() {
    io.grpc.MethodDescriptor<com.distribute.grpc.LsRequest, com.distribute.grpc.MkdirResponse> getCdMethod;
    if ((getCdMethod = DirectoryServiceGrpc.getCdMethod) == null) {
      synchronized (DirectoryServiceGrpc.class) {
        if ((getCdMethod = DirectoryServiceGrpc.getCdMethod) == null) {
          DirectoryServiceGrpc.getCdMethod = getCdMethod =
              io.grpc.MethodDescriptor.<com.distribute.grpc.LsRequest, com.distribute.grpc.MkdirResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "cd"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.distribute.grpc.LsRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.distribute.grpc.MkdirResponse.getDefaultInstance()))
              .setSchemaDescriptor(new DirectoryServiceMethodDescriptorSupplier("cd"))
              .build();
        }
      }
    }
    return getCdMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static DirectoryServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<DirectoryServiceStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<DirectoryServiceStub>() {
        @java.lang.Override
        public DirectoryServiceStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new DirectoryServiceStub(channel, callOptions);
        }
      };
    return DirectoryServiceStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static DirectoryServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<DirectoryServiceBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<DirectoryServiceBlockingStub>() {
        @java.lang.Override
        public DirectoryServiceBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new DirectoryServiceBlockingStub(channel, callOptions);
        }
      };
    return DirectoryServiceBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static DirectoryServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<DirectoryServiceFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<DirectoryServiceFutureStub>() {
        @java.lang.Override
        public DirectoryServiceFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new DirectoryServiceFutureStub(channel, callOptions);
        }
      };
    return DirectoryServiceFutureStub.newStub(factory, channel);
  }

  /**
   */
  public static abstract class DirectoryServiceImplBase implements io.grpc.BindableService {

    /**
     */
    public void ls(com.distribute.grpc.LsRequest request,
        io.grpc.stub.StreamObserver<com.distribute.grpc.LsResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getLsMethod(), responseObserver);
    }

    /**
     */
    public void mkdir(com.distribute.grpc.LsRequest request,
        io.grpc.stub.StreamObserver<com.distribute.grpc.MkdirResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getMkdirMethod(), responseObserver);
    }

    /**
     */
    public void cd(com.distribute.grpc.LsRequest request,
        io.grpc.stub.StreamObserver<com.distribute.grpc.MkdirResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getCdMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getLsMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                com.distribute.grpc.LsRequest,
                com.distribute.grpc.LsResponse>(
                  this, METHODID_LS)))
          .addMethod(
            getMkdirMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                com.distribute.grpc.LsRequest,
                com.distribute.grpc.MkdirResponse>(
                  this, METHODID_MKDIR)))
          .addMethod(
            getCdMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                com.distribute.grpc.LsRequest,
                com.distribute.grpc.MkdirResponse>(
                  this, METHODID_CD)))
          .build();
    }
  }

  /**
   */
  public static final class DirectoryServiceStub extends io.grpc.stub.AbstractAsyncStub<DirectoryServiceStub> {
    private DirectoryServiceStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected DirectoryServiceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new DirectoryServiceStub(channel, callOptions);
    }

    /**
     */
    public void ls(com.distribute.grpc.LsRequest request,
        io.grpc.stub.StreamObserver<com.distribute.grpc.LsResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getLsMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void mkdir(com.distribute.grpc.LsRequest request,
        io.grpc.stub.StreamObserver<com.distribute.grpc.MkdirResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getMkdirMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void cd(com.distribute.grpc.LsRequest request,
        io.grpc.stub.StreamObserver<com.distribute.grpc.MkdirResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getCdMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class DirectoryServiceBlockingStub extends io.grpc.stub.AbstractBlockingStub<DirectoryServiceBlockingStub> {
    private DirectoryServiceBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected DirectoryServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new DirectoryServiceBlockingStub(channel, callOptions);
    }

    /**
     */
    public com.distribute.grpc.LsResponse ls(com.distribute.grpc.LsRequest request) {
      return blockingUnaryCall(
          getChannel(), getLsMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.distribute.grpc.MkdirResponse mkdir(com.distribute.grpc.LsRequest request) {
      return blockingUnaryCall(
          getChannel(), getMkdirMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.distribute.grpc.MkdirResponse cd(com.distribute.grpc.LsRequest request) {
      return blockingUnaryCall(
          getChannel(), getCdMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class DirectoryServiceFutureStub extends io.grpc.stub.AbstractFutureStub<DirectoryServiceFutureStub> {
    private DirectoryServiceFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected DirectoryServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new DirectoryServiceFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.distribute.grpc.LsResponse> ls(
        com.distribute.grpc.LsRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getLsMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.distribute.grpc.MkdirResponse> mkdir(
        com.distribute.grpc.LsRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getMkdirMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.distribute.grpc.MkdirResponse> cd(
        com.distribute.grpc.LsRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getCdMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_LS = 0;
  private static final int METHODID_MKDIR = 1;
  private static final int METHODID_CD = 2;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final DirectoryServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(DirectoryServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_LS:
          serviceImpl.ls((com.distribute.grpc.LsRequest) request,
              (io.grpc.stub.StreamObserver<com.distribute.grpc.LsResponse>) responseObserver);
          break;
        case METHODID_MKDIR:
          serviceImpl.mkdir((com.distribute.grpc.LsRequest) request,
              (io.grpc.stub.StreamObserver<com.distribute.grpc.MkdirResponse>) responseObserver);
          break;
        case METHODID_CD:
          serviceImpl.cd((com.distribute.grpc.LsRequest) request,
              (io.grpc.stub.StreamObserver<com.distribute.grpc.MkdirResponse>) responseObserver);
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

  private static abstract class DirectoryServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    DirectoryServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.distribute.grpc.DirectoryInt.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("DirectoryService");
    }
  }

  private static final class DirectoryServiceFileDescriptorSupplier
      extends DirectoryServiceBaseDescriptorSupplier {
    DirectoryServiceFileDescriptorSupplier() {}
  }

  private static final class DirectoryServiceMethodDescriptorSupplier
      extends DirectoryServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    DirectoryServiceMethodDescriptorSupplier(String methodName) {
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
      synchronized (DirectoryServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new DirectoryServiceFileDescriptorSupplier())
              .addMethod(getLsMethod())
              .addMethod(getMkdirMethod())
              .addMethod(getCdMethod())
              .build();
        }
      }
    }
    return result;
  }
}
