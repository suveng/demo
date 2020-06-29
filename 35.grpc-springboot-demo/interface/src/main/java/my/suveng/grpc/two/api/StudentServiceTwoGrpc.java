package my.suveng.grpc.two.api;

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
    comments = "Source: newTest.proto")
public final class StudentServiceTwoGrpc {

  private StudentServiceTwoGrpc() {}

  public static final String SERVICE_NAME = "StudentServiceTwo";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<my.suveng.grpc.two.api.MyRequestTwo,
      my.suveng.grpc.two.api.MyResponseTwo> getGetRealNameByUsernameMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "getRealNameByUsername",
      requestType = my.suveng.grpc.two.api.MyRequestTwo.class,
      responseType = my.suveng.grpc.two.api.MyResponseTwo.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<my.suveng.grpc.two.api.MyRequestTwo,
      my.suveng.grpc.two.api.MyResponseTwo> getGetRealNameByUsernameMethod() {
    io.grpc.MethodDescriptor<my.suveng.grpc.two.api.MyRequestTwo, my.suveng.grpc.two.api.MyResponseTwo> getGetRealNameByUsernameMethod;
    if ((getGetRealNameByUsernameMethod = StudentServiceTwoGrpc.getGetRealNameByUsernameMethod) == null) {
      synchronized (StudentServiceTwoGrpc.class) {
        if ((getGetRealNameByUsernameMethod = StudentServiceTwoGrpc.getGetRealNameByUsernameMethod) == null) {
          StudentServiceTwoGrpc.getGetRealNameByUsernameMethod = getGetRealNameByUsernameMethod =
              io.grpc.MethodDescriptor.<my.suveng.grpc.two.api.MyRequestTwo, my.suveng.grpc.two.api.MyResponseTwo>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "getRealNameByUsername"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  my.suveng.grpc.two.api.MyRequestTwo.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  my.suveng.grpc.two.api.MyResponseTwo.getDefaultInstance()))
              .setSchemaDescriptor(new StudentServiceTwoMethodDescriptorSupplier("getRealNameByUsername"))
              .build();
        }
      }
    }
    return getGetRealNameByUsernameMethod;
  }

  private static volatile io.grpc.MethodDescriptor<my.suveng.grpc.two.api.MyRequestTwo,
      my.suveng.grpc.two.api.MyResponseTwo> getGetRealNameByUsernameResStreamMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "getRealNameByUsernameResStream",
      requestType = my.suveng.grpc.two.api.MyRequestTwo.class,
      responseType = my.suveng.grpc.two.api.MyResponseTwo.class,
      methodType = io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
  public static io.grpc.MethodDescriptor<my.suveng.grpc.two.api.MyRequestTwo,
      my.suveng.grpc.two.api.MyResponseTwo> getGetRealNameByUsernameResStreamMethod() {
    io.grpc.MethodDescriptor<my.suveng.grpc.two.api.MyRequestTwo, my.suveng.grpc.two.api.MyResponseTwo> getGetRealNameByUsernameResStreamMethod;
    if ((getGetRealNameByUsernameResStreamMethod = StudentServiceTwoGrpc.getGetRealNameByUsernameResStreamMethod) == null) {
      synchronized (StudentServiceTwoGrpc.class) {
        if ((getGetRealNameByUsernameResStreamMethod = StudentServiceTwoGrpc.getGetRealNameByUsernameResStreamMethod) == null) {
          StudentServiceTwoGrpc.getGetRealNameByUsernameResStreamMethod = getGetRealNameByUsernameResStreamMethod =
              io.grpc.MethodDescriptor.<my.suveng.grpc.two.api.MyRequestTwo, my.suveng.grpc.two.api.MyResponseTwo>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "getRealNameByUsernameResStream"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  my.suveng.grpc.two.api.MyRequestTwo.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  my.suveng.grpc.two.api.MyResponseTwo.getDefaultInstance()))
              .setSchemaDescriptor(new StudentServiceTwoMethodDescriptorSupplier("getRealNameByUsernameResStream"))
              .build();
        }
      }
    }
    return getGetRealNameByUsernameResStreamMethod;
  }

  private static volatile io.grpc.MethodDescriptor<my.suveng.grpc.two.api.MyRequestTwo,
      my.suveng.grpc.two.api.MyResponseTwo> getGetRealNameByUsernameReqStreamMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "getRealNameByUsernameReqStream",
      requestType = my.suveng.grpc.two.api.MyRequestTwo.class,
      responseType = my.suveng.grpc.two.api.MyResponseTwo.class,
      methodType = io.grpc.MethodDescriptor.MethodType.CLIENT_STREAMING)
  public static io.grpc.MethodDescriptor<my.suveng.grpc.two.api.MyRequestTwo,
      my.suveng.grpc.two.api.MyResponseTwo> getGetRealNameByUsernameReqStreamMethod() {
    io.grpc.MethodDescriptor<my.suveng.grpc.two.api.MyRequestTwo, my.suveng.grpc.two.api.MyResponseTwo> getGetRealNameByUsernameReqStreamMethod;
    if ((getGetRealNameByUsernameReqStreamMethod = StudentServiceTwoGrpc.getGetRealNameByUsernameReqStreamMethod) == null) {
      synchronized (StudentServiceTwoGrpc.class) {
        if ((getGetRealNameByUsernameReqStreamMethod = StudentServiceTwoGrpc.getGetRealNameByUsernameReqStreamMethod) == null) {
          StudentServiceTwoGrpc.getGetRealNameByUsernameReqStreamMethod = getGetRealNameByUsernameReqStreamMethod =
              io.grpc.MethodDescriptor.<my.suveng.grpc.two.api.MyRequestTwo, my.suveng.grpc.two.api.MyResponseTwo>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.CLIENT_STREAMING)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "getRealNameByUsernameReqStream"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  my.suveng.grpc.two.api.MyRequestTwo.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  my.suveng.grpc.two.api.MyResponseTwo.getDefaultInstance()))
              .setSchemaDescriptor(new StudentServiceTwoMethodDescriptorSupplier("getRealNameByUsernameReqStream"))
              .build();
        }
      }
    }
    return getGetRealNameByUsernameReqStreamMethod;
  }

  private static volatile io.grpc.MethodDescriptor<my.suveng.grpc.two.api.MyRequestTwo,
      my.suveng.grpc.two.api.MyResponseTwo> getGetRealNameByUsernameStreamAllMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "getRealNameByUsernameStreamAll",
      requestType = my.suveng.grpc.two.api.MyRequestTwo.class,
      responseType = my.suveng.grpc.two.api.MyResponseTwo.class,
      methodType = io.grpc.MethodDescriptor.MethodType.BIDI_STREAMING)
  public static io.grpc.MethodDescriptor<my.suveng.grpc.two.api.MyRequestTwo,
      my.suveng.grpc.two.api.MyResponseTwo> getGetRealNameByUsernameStreamAllMethod() {
    io.grpc.MethodDescriptor<my.suveng.grpc.two.api.MyRequestTwo, my.suveng.grpc.two.api.MyResponseTwo> getGetRealNameByUsernameStreamAllMethod;
    if ((getGetRealNameByUsernameStreamAllMethod = StudentServiceTwoGrpc.getGetRealNameByUsernameStreamAllMethod) == null) {
      synchronized (StudentServiceTwoGrpc.class) {
        if ((getGetRealNameByUsernameStreamAllMethod = StudentServiceTwoGrpc.getGetRealNameByUsernameStreamAllMethod) == null) {
          StudentServiceTwoGrpc.getGetRealNameByUsernameStreamAllMethod = getGetRealNameByUsernameStreamAllMethod =
              io.grpc.MethodDescriptor.<my.suveng.grpc.two.api.MyRequestTwo, my.suveng.grpc.two.api.MyResponseTwo>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.BIDI_STREAMING)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "getRealNameByUsernameStreamAll"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  my.suveng.grpc.two.api.MyRequestTwo.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  my.suveng.grpc.two.api.MyResponseTwo.getDefaultInstance()))
              .setSchemaDescriptor(new StudentServiceTwoMethodDescriptorSupplier("getRealNameByUsernameStreamAll"))
              .build();
        }
      }
    }
    return getGetRealNameByUsernameStreamAllMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static StudentServiceTwoStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<StudentServiceTwoStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<StudentServiceTwoStub>() {
        @java.lang.Override
        public StudentServiceTwoStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new StudentServiceTwoStub(channel, callOptions);
        }
      };
    return StudentServiceTwoStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static StudentServiceTwoBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<StudentServiceTwoBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<StudentServiceTwoBlockingStub>() {
        @java.lang.Override
        public StudentServiceTwoBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new StudentServiceTwoBlockingStub(channel, callOptions);
        }
      };
    return StudentServiceTwoBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static StudentServiceTwoFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<StudentServiceTwoFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<StudentServiceTwoFutureStub>() {
        @java.lang.Override
        public StudentServiceTwoFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new StudentServiceTwoFutureStub(channel, callOptions);
        }
      };
    return StudentServiceTwoFutureStub.newStub(factory, channel);
  }

  /**
   * <pre>
   * rpc 方法定义, 4种方式
   * </pre>
   */
  public static abstract class StudentServiceTwoImplBase implements io.grpc.BindableService {

    /**
     * <pre>
     *     1. 普通请求返回
     * </pre>
     */
    public void getRealNameByUsername(my.suveng.grpc.two.api.MyRequestTwo request,
        io.grpc.stub.StreamObserver<my.suveng.grpc.two.api.MyResponseTwo> responseObserver) {
      asyncUnimplementedUnaryCall(getGetRealNameByUsernameMethod(), responseObserver);
    }

    /**
     * <pre>
     *      2. 流式请求,普通返回
     * </pre>
     */
    public void getRealNameByUsernameResStream(my.suveng.grpc.two.api.MyRequestTwo request,
        io.grpc.stub.StreamObserver<my.suveng.grpc.two.api.MyResponseTwo> responseObserver) {
      asyncUnimplementedUnaryCall(getGetRealNameByUsernameResStreamMethod(), responseObserver);
    }

    /**
     * <pre>
     *      3. 普通请求,流式返回
     * </pre>
     */
    public io.grpc.stub.StreamObserver<my.suveng.grpc.two.api.MyRequestTwo> getRealNameByUsernameReqStream(
        io.grpc.stub.StreamObserver<my.suveng.grpc.two.api.MyResponseTwo> responseObserver) {
      return asyncUnimplementedStreamingCall(getGetRealNameByUsernameReqStreamMethod(), responseObserver);
    }

    /**
     * <pre>
     *      3. 流式请求, 流式返回
     * </pre>
     */
    public io.grpc.stub.StreamObserver<my.suveng.grpc.two.api.MyRequestTwo> getRealNameByUsernameStreamAll(
        io.grpc.stub.StreamObserver<my.suveng.grpc.two.api.MyResponseTwo> responseObserver) {
      return asyncUnimplementedStreamingCall(getGetRealNameByUsernameStreamAllMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getGetRealNameByUsernameMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                my.suveng.grpc.two.api.MyRequestTwo,
                my.suveng.grpc.two.api.MyResponseTwo>(
                  this, METHODID_GET_REAL_NAME_BY_USERNAME)))
          .addMethod(
            getGetRealNameByUsernameResStreamMethod(),
            asyncServerStreamingCall(
              new MethodHandlers<
                my.suveng.grpc.two.api.MyRequestTwo,
                my.suveng.grpc.two.api.MyResponseTwo>(
                  this, METHODID_GET_REAL_NAME_BY_USERNAME_RES_STREAM)))
          .addMethod(
            getGetRealNameByUsernameReqStreamMethod(),
            asyncClientStreamingCall(
              new MethodHandlers<
                my.suveng.grpc.two.api.MyRequestTwo,
                my.suveng.grpc.two.api.MyResponseTwo>(
                  this, METHODID_GET_REAL_NAME_BY_USERNAME_REQ_STREAM)))
          .addMethod(
            getGetRealNameByUsernameStreamAllMethod(),
            asyncBidiStreamingCall(
              new MethodHandlers<
                my.suveng.grpc.two.api.MyRequestTwo,
                my.suveng.grpc.two.api.MyResponseTwo>(
                  this, METHODID_GET_REAL_NAME_BY_USERNAME_STREAM_ALL)))
          .build();
    }
  }

  /**
   * <pre>
   * rpc 方法定义, 4种方式
   * </pre>
   */
  public static final class StudentServiceTwoStub extends io.grpc.stub.AbstractAsyncStub<StudentServiceTwoStub> {
    private StudentServiceTwoStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected StudentServiceTwoStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new StudentServiceTwoStub(channel, callOptions);
    }

    /**
     * <pre>
     *     1. 普通请求返回
     * </pre>
     */
    public void getRealNameByUsername(my.suveng.grpc.two.api.MyRequestTwo request,
        io.grpc.stub.StreamObserver<my.suveng.grpc.two.api.MyResponseTwo> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getGetRealNameByUsernameMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     *      2. 流式请求,普通返回
     * </pre>
     */
    public void getRealNameByUsernameResStream(my.suveng.grpc.two.api.MyRequestTwo request,
        io.grpc.stub.StreamObserver<my.suveng.grpc.two.api.MyResponseTwo> responseObserver) {
      asyncServerStreamingCall(
          getChannel().newCall(getGetRealNameByUsernameResStreamMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     *      3. 普通请求,流式返回
     * </pre>
     */
    public io.grpc.stub.StreamObserver<my.suveng.grpc.two.api.MyRequestTwo> getRealNameByUsernameReqStream(
        io.grpc.stub.StreamObserver<my.suveng.grpc.two.api.MyResponseTwo> responseObserver) {
      return asyncClientStreamingCall(
          getChannel().newCall(getGetRealNameByUsernameReqStreamMethod(), getCallOptions()), responseObserver);
    }

    /**
     * <pre>
     *      3. 流式请求, 流式返回
     * </pre>
     */
    public io.grpc.stub.StreamObserver<my.suveng.grpc.two.api.MyRequestTwo> getRealNameByUsernameStreamAll(
        io.grpc.stub.StreamObserver<my.suveng.grpc.two.api.MyResponseTwo> responseObserver) {
      return asyncBidiStreamingCall(
          getChannel().newCall(getGetRealNameByUsernameStreamAllMethod(), getCallOptions()), responseObserver);
    }
  }

  /**
   * <pre>
   * rpc 方法定义, 4种方式
   * </pre>
   */
  public static final class StudentServiceTwoBlockingStub extends io.grpc.stub.AbstractBlockingStub<StudentServiceTwoBlockingStub> {
    private StudentServiceTwoBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected StudentServiceTwoBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new StudentServiceTwoBlockingStub(channel, callOptions);
    }

    /**
     * <pre>
     *     1. 普通请求返回
     * </pre>
     */
    public my.suveng.grpc.two.api.MyResponseTwo getRealNameByUsername(my.suveng.grpc.two.api.MyRequestTwo request) {
      return blockingUnaryCall(
          getChannel(), getGetRealNameByUsernameMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     *      2. 流式请求,普通返回
     * </pre>
     */
    public java.util.Iterator<my.suveng.grpc.two.api.MyResponseTwo> getRealNameByUsernameResStream(
        my.suveng.grpc.two.api.MyRequestTwo request) {
      return blockingServerStreamingCall(
          getChannel(), getGetRealNameByUsernameResStreamMethod(), getCallOptions(), request);
    }
  }

  /**
   * <pre>
   * rpc 方法定义, 4种方式
   * </pre>
   */
  public static final class StudentServiceTwoFutureStub extends io.grpc.stub.AbstractFutureStub<StudentServiceTwoFutureStub> {
    private StudentServiceTwoFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected StudentServiceTwoFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new StudentServiceTwoFutureStub(channel, callOptions);
    }

    /**
     * <pre>
     *     1. 普通请求返回
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<my.suveng.grpc.two.api.MyResponseTwo> getRealNameByUsername(
        my.suveng.grpc.two.api.MyRequestTwo request) {
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
    private final StudentServiceTwoImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(StudentServiceTwoImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_GET_REAL_NAME_BY_USERNAME:
          serviceImpl.getRealNameByUsername((my.suveng.grpc.two.api.MyRequestTwo) request,
              (io.grpc.stub.StreamObserver<my.suveng.grpc.two.api.MyResponseTwo>) responseObserver);
          break;
        case METHODID_GET_REAL_NAME_BY_USERNAME_RES_STREAM:
          serviceImpl.getRealNameByUsernameResStream((my.suveng.grpc.two.api.MyRequestTwo) request,
              (io.grpc.stub.StreamObserver<my.suveng.grpc.two.api.MyResponseTwo>) responseObserver);
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
              (io.grpc.stub.StreamObserver<my.suveng.grpc.two.api.MyResponseTwo>) responseObserver);
        case METHODID_GET_REAL_NAME_BY_USERNAME_STREAM_ALL:
          return (io.grpc.stub.StreamObserver<Req>) serviceImpl.getRealNameByUsernameStreamAll(
              (io.grpc.stub.StreamObserver<my.suveng.grpc.two.api.MyResponseTwo>) responseObserver);
        default:
          throw new AssertionError();
      }
    }
  }

  private static abstract class StudentServiceTwoBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    StudentServiceTwoBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return my.suveng.grpc.two.api.StudentTwo.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("StudentServiceTwo");
    }
  }

  private static final class StudentServiceTwoFileDescriptorSupplier
      extends StudentServiceTwoBaseDescriptorSupplier {
    StudentServiceTwoFileDescriptorSupplier() {}
  }

  private static final class StudentServiceTwoMethodDescriptorSupplier
      extends StudentServiceTwoBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    StudentServiceTwoMethodDescriptorSupplier(String methodName) {
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
      synchronized (StudentServiceTwoGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new StudentServiceTwoFileDescriptorSupplier())
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
