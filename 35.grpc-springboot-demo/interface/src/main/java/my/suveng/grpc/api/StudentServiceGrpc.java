package my.suveng.grpc.api;

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
 * <pre>
 * rpc 方法定义, 4种方式
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.29.0)",
    comments = "Source: test.proto")
public final class StudentServiceGrpc {

  private StudentServiceGrpc() {}

  public static final String SERVICE_NAME = "StudentService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<my.suveng.grpc.api.MyRequest,
      my.suveng.grpc.api.MyResponse> getGetRealNameByUsernameMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "getRealNameByUsername",
      requestType = my.suveng.grpc.api.MyRequest.class,
      responseType = my.suveng.grpc.api.MyResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<my.suveng.grpc.api.MyRequest,
      my.suveng.grpc.api.MyResponse> getGetRealNameByUsernameMethod() {
    io.grpc.MethodDescriptor<my.suveng.grpc.api.MyRequest, my.suveng.grpc.api.MyResponse> getGetRealNameByUsernameMethod;
    if ((getGetRealNameByUsernameMethod = StudentServiceGrpc.getGetRealNameByUsernameMethod) == null) {
      synchronized (StudentServiceGrpc.class) {
        if ((getGetRealNameByUsernameMethod = StudentServiceGrpc.getGetRealNameByUsernameMethod) == null) {
          StudentServiceGrpc.getGetRealNameByUsernameMethod = getGetRealNameByUsernameMethod =
              io.grpc.MethodDescriptor.<my.suveng.grpc.api.MyRequest, my.suveng.grpc.api.MyResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "getRealNameByUsername"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  my.suveng.grpc.api.MyRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  my.suveng.grpc.api.MyResponse.getDefaultInstance()))
              .setSchemaDescriptor(new StudentServiceMethodDescriptorSupplier("getRealNameByUsername"))
              .build();
        }
      }
    }
    return getGetRealNameByUsernameMethod;
  }

  private static volatile io.grpc.MethodDescriptor<my.suveng.grpc.api.MyRequest,
      my.suveng.grpc.api.MyResponse> getGetRealNameByUsernameResStreamMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "getRealNameByUsernameResStream",
      requestType = my.suveng.grpc.api.MyRequest.class,
      responseType = my.suveng.grpc.api.MyResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
  public static io.grpc.MethodDescriptor<my.suveng.grpc.api.MyRequest,
      my.suveng.grpc.api.MyResponse> getGetRealNameByUsernameResStreamMethod() {
    io.grpc.MethodDescriptor<my.suveng.grpc.api.MyRequest, my.suveng.grpc.api.MyResponse> getGetRealNameByUsernameResStreamMethod;
    if ((getGetRealNameByUsernameResStreamMethod = StudentServiceGrpc.getGetRealNameByUsernameResStreamMethod) == null) {
      synchronized (StudentServiceGrpc.class) {
        if ((getGetRealNameByUsernameResStreamMethod = StudentServiceGrpc.getGetRealNameByUsernameResStreamMethod) == null) {
          StudentServiceGrpc.getGetRealNameByUsernameResStreamMethod = getGetRealNameByUsernameResStreamMethod =
              io.grpc.MethodDescriptor.<my.suveng.grpc.api.MyRequest, my.suveng.grpc.api.MyResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "getRealNameByUsernameResStream"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  my.suveng.grpc.api.MyRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  my.suveng.grpc.api.MyResponse.getDefaultInstance()))
              .setSchemaDescriptor(new StudentServiceMethodDescriptorSupplier("getRealNameByUsernameResStream"))
              .build();
        }
      }
    }
    return getGetRealNameByUsernameResStreamMethod;
  }

  private static volatile io.grpc.MethodDescriptor<my.suveng.grpc.api.MyRequest,
      my.suveng.grpc.api.MyResponse> getGetRealNameByUsernameReqStreamMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "getRealNameByUsernameReqStream",
      requestType = my.suveng.grpc.api.MyRequest.class,
      responseType = my.suveng.grpc.api.MyResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.CLIENT_STREAMING)
  public static io.grpc.MethodDescriptor<my.suveng.grpc.api.MyRequest,
      my.suveng.grpc.api.MyResponse> getGetRealNameByUsernameReqStreamMethod() {
    io.grpc.MethodDescriptor<my.suveng.grpc.api.MyRequest, my.suveng.grpc.api.MyResponse> getGetRealNameByUsernameReqStreamMethod;
    if ((getGetRealNameByUsernameReqStreamMethod = StudentServiceGrpc.getGetRealNameByUsernameReqStreamMethod) == null) {
      synchronized (StudentServiceGrpc.class) {
        if ((getGetRealNameByUsernameReqStreamMethod = StudentServiceGrpc.getGetRealNameByUsernameReqStreamMethod) == null) {
          StudentServiceGrpc.getGetRealNameByUsernameReqStreamMethod = getGetRealNameByUsernameReqStreamMethod =
              io.grpc.MethodDescriptor.<my.suveng.grpc.api.MyRequest, my.suveng.grpc.api.MyResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.CLIENT_STREAMING)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "getRealNameByUsernameReqStream"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  my.suveng.grpc.api.MyRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  my.suveng.grpc.api.MyResponse.getDefaultInstance()))
              .setSchemaDescriptor(new StudentServiceMethodDescriptorSupplier("getRealNameByUsernameReqStream"))
              .build();
        }
      }
    }
    return getGetRealNameByUsernameReqStreamMethod;
  }

  private static volatile io.grpc.MethodDescriptor<my.suveng.grpc.api.MyRequest,
      my.suveng.grpc.api.MyResponse> getGetRealNameByUsernameStreamAllMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "getRealNameByUsernameStreamAll",
      requestType = my.suveng.grpc.api.MyRequest.class,
      responseType = my.suveng.grpc.api.MyResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.BIDI_STREAMING)
  public static io.grpc.MethodDescriptor<my.suveng.grpc.api.MyRequest,
      my.suveng.grpc.api.MyResponse> getGetRealNameByUsernameStreamAllMethod() {
    io.grpc.MethodDescriptor<my.suveng.grpc.api.MyRequest, my.suveng.grpc.api.MyResponse> getGetRealNameByUsernameStreamAllMethod;
    if ((getGetRealNameByUsernameStreamAllMethod = StudentServiceGrpc.getGetRealNameByUsernameStreamAllMethod) == null) {
      synchronized (StudentServiceGrpc.class) {
        if ((getGetRealNameByUsernameStreamAllMethod = StudentServiceGrpc.getGetRealNameByUsernameStreamAllMethod) == null) {
          StudentServiceGrpc.getGetRealNameByUsernameStreamAllMethod = getGetRealNameByUsernameStreamAllMethod =
              io.grpc.MethodDescriptor.<my.suveng.grpc.api.MyRequest, my.suveng.grpc.api.MyResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.BIDI_STREAMING)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "getRealNameByUsernameStreamAll"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  my.suveng.grpc.api.MyRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  my.suveng.grpc.api.MyResponse.getDefaultInstance()))
              .setSchemaDescriptor(new StudentServiceMethodDescriptorSupplier("getRealNameByUsernameStreamAll"))
              .build();
        }
      }
    }
    return getGetRealNameByUsernameStreamAllMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static StudentServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<StudentServiceStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<StudentServiceStub>() {
        @java.lang.Override
        public StudentServiceStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new StudentServiceStub(channel, callOptions);
        }
      };
    return StudentServiceStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static StudentServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<StudentServiceBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<StudentServiceBlockingStub>() {
        @java.lang.Override
        public StudentServiceBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new StudentServiceBlockingStub(channel, callOptions);
        }
      };
    return StudentServiceBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static StudentServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<StudentServiceFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<StudentServiceFutureStub>() {
        @java.lang.Override
        public StudentServiceFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new StudentServiceFutureStub(channel, callOptions);
        }
      };
    return StudentServiceFutureStub.newStub(factory, channel);
  }

  /**
   * <pre>
   * rpc 方法定义, 4种方式
   * </pre>
   */
  public static abstract class StudentServiceImplBase implements io.grpc.BindableService {

    /**
     * <pre>
     *     1. 普通请求返回
     * </pre>
     */
    public void getRealNameByUsername(my.suveng.grpc.api.MyRequest request,
        io.grpc.stub.StreamObserver<my.suveng.grpc.api.MyResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getGetRealNameByUsernameMethod(), responseObserver);
    }

    /**
     * <pre>
     *      2. 流式请求,普通返回
     * </pre>
     */
    public void getRealNameByUsernameResStream(my.suveng.grpc.api.MyRequest request,
        io.grpc.stub.StreamObserver<my.suveng.grpc.api.MyResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getGetRealNameByUsernameResStreamMethod(), responseObserver);
    }

    /**
     * <pre>
     *      3. 普通请求,流式返回
     * </pre>
     */
    public io.grpc.stub.StreamObserver<my.suveng.grpc.api.MyRequest> getRealNameByUsernameReqStream(
        io.grpc.stub.StreamObserver<my.suveng.grpc.api.MyResponse> responseObserver) {
      return asyncUnimplementedStreamingCall(getGetRealNameByUsernameReqStreamMethod(), responseObserver);
    }

    /**
     * <pre>
     *      3. 流式请求, 流式返回
     * </pre>
     */
    public io.grpc.stub.StreamObserver<my.suveng.grpc.api.MyRequest> getRealNameByUsernameStreamAll(
        io.grpc.stub.StreamObserver<my.suveng.grpc.api.MyResponse> responseObserver) {
      return asyncUnimplementedStreamingCall(getGetRealNameByUsernameStreamAllMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getGetRealNameByUsernameMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                my.suveng.grpc.api.MyRequest,
                my.suveng.grpc.api.MyResponse>(
                  this, METHODID_GET_REAL_NAME_BY_USERNAME)))
          .addMethod(
            getGetRealNameByUsernameResStreamMethod(),
            asyncServerStreamingCall(
              new MethodHandlers<
                my.suveng.grpc.api.MyRequest,
                my.suveng.grpc.api.MyResponse>(
                  this, METHODID_GET_REAL_NAME_BY_USERNAME_RES_STREAM)))
          .addMethod(
            getGetRealNameByUsernameReqStreamMethod(),
            asyncClientStreamingCall(
              new MethodHandlers<
                my.suveng.grpc.api.MyRequest,
                my.suveng.grpc.api.MyResponse>(
                  this, METHODID_GET_REAL_NAME_BY_USERNAME_REQ_STREAM)))
          .addMethod(
            getGetRealNameByUsernameStreamAllMethod(),
            asyncBidiStreamingCall(
              new MethodHandlers<
                my.suveng.grpc.api.MyRequest,
                my.suveng.grpc.api.MyResponse>(
                  this, METHODID_GET_REAL_NAME_BY_USERNAME_STREAM_ALL)))
          .build();
    }
  }

  /**
   * <pre>
   * rpc 方法定义, 4种方式
   * </pre>
   */
  public static final class StudentServiceStub extends io.grpc.stub.AbstractAsyncStub<StudentServiceStub> {
    private StudentServiceStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected StudentServiceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new StudentServiceStub(channel, callOptions);
    }

    /**
     * <pre>
     *     1. 普通请求返回
     * </pre>
     */
    public void getRealNameByUsername(my.suveng.grpc.api.MyRequest request,
        io.grpc.stub.StreamObserver<my.suveng.grpc.api.MyResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getGetRealNameByUsernameMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     *      2. 流式请求,普通返回
     * </pre>
     */
    public void getRealNameByUsernameResStream(my.suveng.grpc.api.MyRequest request,
        io.grpc.stub.StreamObserver<my.suveng.grpc.api.MyResponse> responseObserver) {
      asyncServerStreamingCall(
          getChannel().newCall(getGetRealNameByUsernameResStreamMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     *      3. 普通请求,流式返回
     * </pre>
     */
    public io.grpc.stub.StreamObserver<my.suveng.grpc.api.MyRequest> getRealNameByUsernameReqStream(
        io.grpc.stub.StreamObserver<my.suveng.grpc.api.MyResponse> responseObserver) {
      return asyncClientStreamingCall(
          getChannel().newCall(getGetRealNameByUsernameReqStreamMethod(), getCallOptions()), responseObserver);
    }

    /**
     * <pre>
     *      3. 流式请求, 流式返回
     * </pre>
     */
    public io.grpc.stub.StreamObserver<my.suveng.grpc.api.MyRequest> getRealNameByUsernameStreamAll(
        io.grpc.stub.StreamObserver<my.suveng.grpc.api.MyResponse> responseObserver) {
      return asyncBidiStreamingCall(
          getChannel().newCall(getGetRealNameByUsernameStreamAllMethod(), getCallOptions()), responseObserver);
    }
  }

  /**
   * <pre>
   * rpc 方法定义, 4种方式
   * </pre>
   */
  public static final class StudentServiceBlockingStub extends io.grpc.stub.AbstractBlockingStub<StudentServiceBlockingStub> {
    private StudentServiceBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected StudentServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new StudentServiceBlockingStub(channel, callOptions);
    }

    /**
     * <pre>
     *     1. 普通请求返回
     * </pre>
     */
    public my.suveng.grpc.api.MyResponse getRealNameByUsername(my.suveng.grpc.api.MyRequest request) {
      return blockingUnaryCall(
          getChannel(), getGetRealNameByUsernameMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     *      2. 流式请求,普通返回
     * </pre>
     */
    public java.util.Iterator<my.suveng.grpc.api.MyResponse> getRealNameByUsernameResStream(
        my.suveng.grpc.api.MyRequest request) {
      return blockingServerStreamingCall(
          getChannel(), getGetRealNameByUsernameResStreamMethod(), getCallOptions(), request);
    }
  }

  /**
   * <pre>
   * rpc 方法定义, 4种方式
   * </pre>
   */
  public static final class StudentServiceFutureStub extends io.grpc.stub.AbstractFutureStub<StudentServiceFutureStub> {
    private StudentServiceFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected StudentServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new StudentServiceFutureStub(channel, callOptions);
    }

    /**
     * <pre>
     *     1. 普通请求返回
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<my.suveng.grpc.api.MyResponse> getRealNameByUsername(
        my.suveng.grpc.api.MyRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getGetRealNameByUsernameMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_GET_REAL_NAME_BY_USERNAME = 0;
  private static final int METHODID_GET_REAL_NAME_BY_USERNAME_RES_STREAM = 1;
  private static final int METHODID_GET_REAL_NAME_BY_USERNAME_REQ_STREAM = 2;
  private static final int METHODID_GET_REAL_NAME_BY_USERNAME_STREAM_ALL = 3;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final StudentServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(StudentServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_GET_REAL_NAME_BY_USERNAME:
          serviceImpl.getRealNameByUsername((my.suveng.grpc.api.MyRequest) request,
              (io.grpc.stub.StreamObserver<my.suveng.grpc.api.MyResponse>) responseObserver);
          break;
        case METHODID_GET_REAL_NAME_BY_USERNAME_RES_STREAM:
          serviceImpl.getRealNameByUsernameResStream((my.suveng.grpc.api.MyRequest) request,
              (io.grpc.stub.StreamObserver<my.suveng.grpc.api.MyResponse>) responseObserver);
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
        case METHODID_GET_REAL_NAME_BY_USERNAME_REQ_STREAM:
          return (io.grpc.stub.StreamObserver<Req>) serviceImpl.getRealNameByUsernameReqStream(
              (io.grpc.stub.StreamObserver<my.suveng.grpc.api.MyResponse>) responseObserver);
        case METHODID_GET_REAL_NAME_BY_USERNAME_STREAM_ALL:
          return (io.grpc.stub.StreamObserver<Req>) serviceImpl.getRealNameByUsernameStreamAll(
              (io.grpc.stub.StreamObserver<my.suveng.grpc.api.MyResponse>) responseObserver);
        default:
          throw new AssertionError();
      }
    }
  }

  private static abstract class StudentServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    StudentServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return my.suveng.grpc.api.Student.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("StudentService");
    }
  }

  private static final class StudentServiceFileDescriptorSupplier
      extends StudentServiceBaseDescriptorSupplier {
    StudentServiceFileDescriptorSupplier() {}
  }

  private static final class StudentServiceMethodDescriptorSupplier
      extends StudentServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    StudentServiceMethodDescriptorSupplier(String methodName) {
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
      synchronized (StudentServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new StudentServiceFileDescriptorSupplier())
              .addMethod(getGetRealNameByUsernameMethod())
              .addMethod(getGetRealNameByUsernameResStreamMethod())
              .addMethod(getGetRealNameByUsernameReqStreamMethod())
              .addMethod(getGetRealNameByUsernameStreamAllMethod())
              .build();
        }
      }
    }
    return result;
  }
}
