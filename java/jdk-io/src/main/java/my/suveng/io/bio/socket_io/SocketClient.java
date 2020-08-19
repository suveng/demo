package my.suveng.io.bio.socket_io;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;
import java.net.SocketTimeoutException;

/**
 *
 * @author suwenguang
 **/
public class SocketClient {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("127.0.0.1", 8096);
        socket.setSoTimeout(10000);// read的超时时间
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in)); // 获取键盘输入
        // 获取Socket的输出流和输入流---发送数据到服务端，接收从服务端发送过来的数据
        PrintStream out = new PrintStream(socket.getOutputStream());
        BufferedReader buf = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        boolean flag = true;
        while (flag) {
            System.out.print("输入信息：");
            String str = input.readLine();
            out.println(str); // 发送数据到服务端
            if ("bye".equals(str)) {
                flag = false;
            } else {
                try {
                    String echo = buf.readLine();
                    System.out.println(echo);
                } catch (SocketTimeoutException e) {
                    System.out.println("Time out, No response");
                }
            }
        }
        input.close();
        if (socket != null) {
            // 如果构造函数建立起了连接，则关闭套接字，如果没有建立起连接，自然不用关闭
            socket.close(); // 只关闭socket，其关联的输入输出流也会被关闭
        }
    }

}
