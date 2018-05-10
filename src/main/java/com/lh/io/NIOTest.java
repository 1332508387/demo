package com.lh.io;

import org.junit.jupiter.api.Test;

import java.io.*;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class NIOTest {
    @Test
    public void test() {
        try (FileInputStream inputStream = new FileInputStream(IOTest.FILE_NAME);
            FileOutputStream outputStream = new FileOutputStream(IOTest.SERIALIZED_FILE_NAME)) {
            FileChannel in = inputStream.getChannel();
            FileChannel out = outputStream.getChannel();
            StringBuilder sb = new StringBuilder();
            ByteBuffer buffer = ByteBuffer.allocate(1024);
            while (true) {
                buffer.clear();
                int flag = in.read(buffer);
                if (flag == -1) {
                    break;
                }
                buffer.flip();

//                byte[] data = buffer.array();
//                sb.append(new String(data));
                out.write(buffer);
            }
            System.out.println(sb.toString());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
