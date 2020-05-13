package my.suveng.grpcdemomaven.impl;

import io.grpc.stub.StreamObserver;
import my.suveng.grpcdemomaven.grpc.MyRequest;
import my.suveng.grpcdemomaven.grpc.MyResponse;
import my.suveng.grpcdemomaven.grpc.StudentServiceGrpc;

/**
 *
 * @author suwenguang
 **/
public class StudentServiceImpl extends StudentServiceGrpc.StudentServiceImplBase {
	@Override
	public void getRealNameByUsername(MyRequest request, StreamObserver<MyResponse> responseObserver) {
		System.out.println("接受到参数: " + request + "");
		MyResponse response = MyResponse.newBuilder().setRealname("hello").build();
		responseObserver.onNext(response);
		responseObserver.onCompleted();
	}
}
