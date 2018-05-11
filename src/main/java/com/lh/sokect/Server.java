package com.lh.sokect;

import com.sun.deploy.trace.SocketTraceListener;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(8888);
            Socket socket = null;
            System.out.println("服务器启动。。。");
            while (true) {
                socket = serverSocket.accept();
               /* InputStream in = socket.getInputStream();
                byte[] buff = new byte[1024];
                int len = 0;
                while ((len = in.read(buff)) != -1) {
                	System.out.println("接受到数据：");
                	String data = new String(buff, 0, len);
                	System.out.println(data);
                }*/
                new Thread(new Secondary(socket)).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static class Secondary implements Runnable {
        private Socket socket;

        public Secondary() {

        }

        public Secondary(Socket socket) {
            this.socket = socket;
        }

        @Override
        public void run() {
            InputStream in = null;
            try {
                in = socket.getInputStream();
                byte[] buff = new byte[1024];
                int len = 0;
                while ((len = in.read(buff)) != -1) {
                    System.out.println(Thread.currentThread().getId() + "-接受到数据：socket" + socket);
                    String data = new String(buff, 0, len);
                    System.out.println(data);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}
