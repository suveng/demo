package my.suveng.io.bio.socket_io;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.atomic.AtomicInteger;

/**
 *
 * @author suwenguang
 **/
public class SocketServer implements Runnable {
	private static final AtomicInteger count = new AtomicInteger(0);

	//server 入口
	public static void main(String[] args) throws IOException {
		ServerSocket serverSocket = new ServerSocket(8096);
		while (true) {
			//
			Socket accept = serverSocket.accept();
			System.out.println("客户端连接成功," + count.incrementAndGet());
			new Thread(new SocketServer(accept)).start();
		}
	}

	private Socket client = null;

	public SocketServer(Socket client) {
		this.client = client;
	}

	@Override
	public void run() {
		try {
			//获取Socket的输出流，用来向客户端发送数据
			PrintStream out = new PrintStream(client.getOutputStream());
			//获取Socket的输入流，用来接收从客户端发送过来的数据
			BufferedReader buf = new BufferedReader(new InputStreamReader(client.getInputStream()));
			boolean flag = true;
			while (flag) {
				//接收从客户端发送过来的数据
				String str = buf.readLine();
				if (str == null || "".equals(str)) {
					flag = false;
				} else {
					if ("bye".equals(str)) {
						flag = false;
					} else {
						//将接收到的字符串前面加上echo，发送到对应的客户端
						out.println("输出信息:" + str);
					}
				}
			}
			out.close();
			client.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
