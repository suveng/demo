package my.suveng.grpcdemomaven.server;

import io.grpc.Server;
import io.grpc.ServerBuilder;
import my.suveng.grpcdemomaven.impl.StudentServiceImpl;

import java.io.IOException;

/**
 *
 * @author suwenguang
 **/
public class GrpcServer {
	private Server server;

	private void start() throws IOException {
		this.server = ServerBuilder
			.forPort(9999)
			.addService(new StudentServiceImpl())
			.build()
			.start();
		System.out.println("服务启动...");

		Runtime.getRuntime().addShutdownHook(new Thread(() -> {
			System.out.println("添加jvm钩子,关闭jvm前,调用stop方法");
			stop();
		}));
	}

	private void stop() {
		if (null != server) {
			server.shutdown();
		}
	}

	private void awaitTermination() throws InterruptedException {
		if (null != server){
			server.awaitTermination();
		}
	}

	public static void main(String[] args) throws IOException, InterruptedException {
		GrpcServer grpcServer = new GrpcServer();
		try {
			grpcServer.start();
		} catch (IOException e) {
			System.out.println("服务启动失败....");
			System.out.println(e.getMessage());
		}

		grpcServer.awaitTermination();
	}
}
