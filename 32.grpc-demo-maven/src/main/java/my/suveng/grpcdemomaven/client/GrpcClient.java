package my.suveng.grpcdemomaven.client;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import my.suveng.grpcdemomaven.grpc.MyRequest;
import my.suveng.grpcdemomaven.grpc.MyResponse;
import my.suveng.grpcdemomaven.grpc.StudentServiceGrpc;

/**
 *
 * @author suwenguang
 **/
public class GrpcClient {
	public static void main(String[] args) {

		ManagedChannel managedChannel = ManagedChannelBuilder
			.forAddress("127.0.0.1", 9999)
			.usePlaintext()
			.build();
		StudentServiceGrpc.StudentServiceBlockingStub blockingStub = StudentServiceGrpc.newBlockingStub(managedChannel);
		MyRequest wwww = MyRequest.newBuilder().setUsername("wwww").build();
		MyResponse byUsername = blockingStub.getRealNameByUsername(wwww);
		System.out.println("服务器返回: " + byUsername);
	}
}
