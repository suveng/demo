package my.suveng.client.api;

import com.alibaba.fastjson.JSON;
import my.suveng.grpc.api.MyRequest;
import my.suveng.grpc.api.MyResponse;
import my.suveng.grpc.api.StudentServiceGrpc;
import my.suveng.grpc.two.api.MyRequestTwo;
import my.suveng.grpc.two.api.MyResponseTwo;
import my.suveng.grpc.two.api.StudentServiceTwoGrpc;
import net.devh.boot.grpc.client.inject.GrpcClient;
import org.springframework.stereotype.Service;

/**
 *
 * @author suwenguang
 **/
@Service
public class ApiService {

	@GrpcClient("student")
	StudentServiceGrpc.StudentServiceBlockingStub studentService;

	@GrpcClient("student")
	StudentServiceTwoGrpc.StudentServiceTwoBlockingStub two;


	public String grpc() {
		MyRequest hello = MyRequest.newBuilder().setUsername("hello").build();
		MyResponse realNameByUsername = studentService.getRealNameByUsername(hello);
		MyRequestTwo build = MyRequestTwo.newBuilder().setUsername("2").build();
		MyResponseTwo twoRes = this.two.getRealNameByUsername(build);
		return realNameByUsername+","+twoRes+"";
	}
}
