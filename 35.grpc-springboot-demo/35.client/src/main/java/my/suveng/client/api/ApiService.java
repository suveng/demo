package my.suveng.client.api;

import com.alibaba.fastjson.JSON;
import my.suveng.grpc.api.MyRequest;
import my.suveng.grpc.api.MyResponse;
import my.suveng.grpc.api.StudentServiceGrpc;
import net.devh.boot.grpc.client.inject.GrpcClient;
import org.springframework.stereotype.Service;

/**
 *
 * @author suwenguang
 **/
@Service
public class ApiService {

	@GrpcClient("studentService")
	StudentServiceGrpc.StudentServiceBlockingStub studentService;


	public String grpc() {
		MyRequest hello = MyRequest.newBuilder().setUsername("hello").build();
		MyResponse realNameByUsername = studentService.getRealNameByUsername(hello);
		return realNameByUsername+"";
	}
}
