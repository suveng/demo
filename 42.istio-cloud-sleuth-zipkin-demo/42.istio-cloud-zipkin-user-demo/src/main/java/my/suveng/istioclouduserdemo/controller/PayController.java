package my.suveng.istioclouduserdemo.controller;

import my.suveng.istio.grpc.api.order.OrderRequest;
import my.suveng.istio.grpc.api.order.OrderResponse;
import my.suveng.istio.grpc.api.order.OrderServiceGrpc;
import my.suveng.istio.grpc.api.pay.PayRequest;
import my.suveng.istio.grpc.api.pay.PayResponse;
import my.suveng.istio.grpc.api.pay.PayServiceGrpc;
import my.suveng.model.common.interfaces.response.IMessage;
import my.suveng.model.common.response.Message;
import my.suveng.util.json.Jackson;
import net.devh.boot.grpc.client.inject.GrpcClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author suwenguang
 **/
@RestController
public class PayController {

	@GrpcClient("pay")
	private PayServiceGrpc.PayServiceBlockingStub payServiceBlockingStub;

	@GrpcClient("order")
	private OrderServiceGrpc.OrderServiceBlockingStub orderServiceBlockingStub;

	@GetMapping("/pay")
	public IMessage<String> pay() {
		OrderResponse orderResult = orderServiceBlockingStub.getRealNameByUsername(OrderRequest.newBuilder().setPay("true").build());
		PayResponse result = payServiceBlockingStub.getRealNameByUsername(PayRequest.newBuilder().setMoney("123").build());
		return Message.successWithData(result.toString());
	}


}
