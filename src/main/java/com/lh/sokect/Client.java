package com.lh.sokect;

import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) {
    	Socket socket = null;
    	Scanner scanner = null;
        try {
        	socket = new Socket("127.0.0.1", 8888);
            OutputStream out = socket.getOutputStream();
            System.out.println("客户端启动。。。");
            while (true) {
            	System.out.println("请输入：");
                scanner = new Scanner(System.in);
                String data = scanner.next();
                out.write(data.getBytes());
                out.flush();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
        	if (socket != null) {
        		try {
					socket.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
        	}
        }
    }
}
