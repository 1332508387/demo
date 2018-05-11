package com.lh.sokect;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;

public class NioServer {
    public static void main(String[] args) throws IOException, InterruptedException {
        ServerSocketChannel socketChannel = ServerSocketChannel.open();
        socketChannel.socket().bind(new InetSocketAddress(8888));
        socketChannel.configureBlocking(false);

        ByteBuffer buffer = ByteBuffer.allocate(1024);
        while (true) {
            System.out.println("等待连接。。。");
            SocketChannel socket = socketChannel.accept();
            if (socket == null) {
//                TimeUnit.SECONDS.sleep(2000);
                Thread.sleep(2000);
            } else {
                System.out.println("接收到数据：");
                int len = socket.read(buffer);
                buffer.flip();
                byte[] data = new byte[len];
                buffer.get(data, 0, len);
                System.out.println(new String(data));
                buffer.clear();
                socket.close();
            }
        }
    }
}
