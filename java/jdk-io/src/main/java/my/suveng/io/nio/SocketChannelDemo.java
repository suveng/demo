package my.suveng.io.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;

/**
 * 网络nio
 * 
 * @author suwenguang
 **/
public class SocketChannelDemo {
    public static void main(String[] args) throws IOException {
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
        serverSocketChannel.socket().bind(new InetSocketAddress(9999));
        while (true) {
            SocketChannel socketChannel = serverSocketChannel.accept();
            // do something with socketChannel...
        }
    }
}
