package my.suveng.grpcdemomaven.client;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.stub.StreamObserver;
import my.suveng.grpcdemomaven.grpc.MyRequest;
import my.suveng.grpcdemomaven.grpc.MyResponse;
import my.suveng.grpcdemomaven.grpc.StudentServiceGrpc;

import java.util.Date;
import java.util.Iterator;

/**
 *
 * @author suwenguang
 **/
public class GrpcClient {
	public static void main(String[] args) throws InterruptedException {

		ManagedChannel managedChannel = ManagedChannelBuilder
			.forAddress("127.0.0.1", 9999)
			.usePlaintext()
			.build();
		StudentServiceGrpc.StudentServiceBlockingStub blockingStub = StudentServiceGrpc.newBlockingStub(managedChannel);
		MyRequest request = MyRequest.newBuilder().setUsername("wwww").build();



		// 客户端流式调用, 构建返回的回调对象
		StreamObserver<MyResponse> myResponseStreamObserver = new StreamObserver<MyResponse>() {
			@Override
			public void onNext(MyResponse value) {
				System.out.println("client onNext: "+ value.getRealname());
			}

			@Override
			public void onError(Throwable t) {
				t.printStackTrace();
			}

			@Override
			public void onCompleted() {
				System.out.println("onCompleted");
			}
		};

		// 异步调用客户端 asyncStub
		StudentServiceGrpc.StudentServiceStub asyncStub = StudentServiceGrpc.newStub(managedChannel);

		// 客户端普通调用,同步阻塞,类似HTTP
		System.out.println("----------分割线 普通 同步阻塞---------------");
		MyResponse byUsername = blockingStub.getRealNameByUsername(request);
		System.out.println("服务器返回: " + byUsername);

		System.out.println("----------分割线 普通但是异步---------------");
		asyncStub.getRealNameByUsername(request,myResponseStreamObserver);


		System.out.println("----------分割线 流式 同步 res stream---------------");
		Iterator<MyResponse> iterator = blockingStub.getRealNameByUsernameResStream(request);
		if (iterator.hasNext()) {
			MyResponse next = iterator.next();
			System.out.println(next.getRealname());
		}

		System.out.println("----------分割线 流式 异步 req stream---------------");
		// 这种客户端调用的方式比较复杂, 需要主动调用 onNext方法, 最后必须调用onCompleted方法才算发送完成
		StreamObserver<MyRequest> reqStream = asyncStub.getRealNameByUsernameReqStream(myResponseStreamObserver);
		reqStream.onNext(request);
		reqStream.onNext(MyRequest.newBuilder().setUsername(String.valueOf(System.currentTimeMillis())).build());
		reqStream.onCompleted();

		System.out.println("----------分割线 流式 异步 all stream---------------");
		StreamObserver<MyRequest> allStream = asyncStub.getRealNameByUsernameStreamAll(myResponseStreamObserver);
		allStream.onNext(MyRequest.newBuilder().setUsername("all-stream-1").build());
		allStream.onNext(MyRequest.newBuilder().setUsername("all-stream-2").build());
		allStream.onNext(MyRequest.newBuilder().setUsername("all-stream-3").build());
		allStream.onNext(MyRequest.newBuilder().setUsername("all-stream-4").build());
		allStream.onCompleted();

		// 异步调用, 程序不能退出哦, 退出就没了
		Thread.sleep(10000);
	}
}
