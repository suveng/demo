package my.suveng.istioclouduserdemo.controller;

import brave.Tracer;
import lombok.extern.slf4j.Slf4j;
import my.suveng.istio.grpc.api.order.OrderRequest;
import my.suveng.istio.grpc.api.order.OrderResponse;
import my.suveng.istio.grpc.api.order.OrderServiceGrpc;
import my.suveng.istio.grpc.api.pay.PayRequest;
import my.suveng.istio.grpc.api.pay.PayResponse;
import my.suveng.istio.grpc.api.pay.PayServiceGrpc;
import my.suveng.istioclouduserdemo.consumer.Service;
import my.suveng.model.common.interfaces.response.IMessage;
import my.suveng.model.common.response.Message;
import my.suveng.util.json.Jackson;
import net.devh.boot.grpc.client.inject.GrpcClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.*;

/**
 *
 * @author suwenguang
 **/
@RestController
@Slf4j
public class PayController {

	@GrpcClient("pay")
	private PayServiceGrpc.PayServiceBlockingStub payServiceBlockingStub;

	@GrpcClient("order")
	private OrderServiceGrpc.OrderServiceBlockingStub orderServiceBlockingStub;

	@Autowired
	Tracer tracer;

	@Autowired
	Service service;

	@GetMapping("/pay")
	public IMessage<String> pay() throws ExecutionException, InterruptedException {
		// 使用原生的是不行的
		//FutureTask<String> futureTask = new FutureTask<>(new Callable<String>() {
		//	@Override
		//	public String call() throws Exception {
		//		OrderResponse orderResult = orderServiceBlockingStub.getRealNameByUsername(OrderRequest.newBuilder().setPay("true").build());
		//		//System.out.println(tracer.currentSpan().context().traceId());
		//		return "hello";
		//	}
		//});
		//new Thread(futureTask).start();
		//
		//String s = futureTask.get();
		//
		//FutureTask<String> task = new FutureTask<>(new Callable<String>() {
		//	@Override
		//	public String call() throws Exception {
		//		PayResponse result = payServiceBlockingStub.getRealNameByUsername(PayRequest.newBuilder().setMoney("123").build());
		//		//System.out.println(tracer.currentSpan().context().traceId());
		//
		//		return "123";
		//	}
		//});
		//new Thread(task).start();
		//String s1 = task.get();

		log.info("1");
		// 配置sleuth提供线程池, 配合@Async注解使用 能够成功
		service.t1();
		service.t2();

		Future<String> at1 = service.at1();

		try {
			String s2 = at1.get(100, TimeUnit.MILLISECONDS);
		} catch (TimeoutException e) {
			e.printStackTrace();
		}

		Future<String> at2 = service.at2();
		try {
			String s2 = at2.get(100, TimeUnit.MILLISECONDS);
		} catch (TimeoutException e) {
			e.printStackTrace();
		}

		return Message.successWithData(tracer.currentSpan().context().traceIdString());
	}


}
