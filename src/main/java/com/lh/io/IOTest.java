package com.lh.io;

import jdk.internal.util.xml.impl.Input;
import org.junit.jupiter.api.Test;
import sun.font.TrueTypeFont;
import sun.security.util.Length;

import javax.swing.event.ChangeEvent;
import java.io.*;
import java.nio.channels.FileChannel;

public class IOTest {
    private static final String FILE_NAME = "data.txt";
    private static final String SERIALIZED_FILE_NAME = "serialized.txt";

    /**
     * InputStream：字节输入流，读文件
     */
    @Test
    public void testInputStream() {

        try (InputStream in = new FileInputStream(new File("data.txt"))) {
            byte[] buff = new byte[1024];
            int len = 0;
            StringBuilder sb =  new StringBuilder();
            while ((len = in.read(buff)) != -1)  {
                sb.append(new String(buff, 0, len));
            }
            System.out.println(sb.toString());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * OutPutStream：字节输出流，写文件
     */
    @Test
    public void testOutPutStream() {
        try (OutputStream out = new FileOutputStream("data.txt", true)) {
            String data = "Hello Java BIO.";
            byte[] datas = data.getBytes();
            out.write(datas);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Reader：字符输入流，读文件
     */
    @Test
    public void testReader() {
        try (Reader reader = new FileReader(FILE_NAME)) {
            char[] buff = new char[1024];
            int len = 0;
            StringBuilder sb = new StringBuilder();
            while ((len = reader.read(buff)) != -1) {
                String str = new String(buff, 0, len);
                sb.append(str);
            }
            System.out.println(sb.toString());

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Writer：字符输出流，写数据
     */
    @Test
    public void testWriter() {
        String data = "\nHello Writer.";
        try (Writer writer = new FileWriter(FILE_NAME, true)) {
            writer.write(data);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * InputStreamReader：可以将字节流转化为字符流
     */
    @Test
    public void testInputStreamReader() {
        InputStream in = null;
        InputStreamReader reader = null;
        try {
            in = new FileInputStream(FILE_NAME);
            reader = new InputStreamReader(in);
            char[] buffer = new char[1024];
            int len = 0;
            StringBuilder sb = new StringBuilder();
            while ((len = reader.read(buffer)) != -1) {
                sb.append(new String(buffer, 0, len));
            }
            System.out.println(sb.toString());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (in != null) {
                try {
                    in.close();
                } catch (IOException e) {
                    in = null;
                }
            }
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e) {
                    reader = null;
                }
            }
        }
    }

    @Test
    public void testOutPutStreamWriter() {

    }

    /**
     * BufferedReader：读一行
     */
    @Test
    public void testBufferedReader() {
        try (BufferedInputStream in = new BufferedInputStream(new FileInputStream(FILE_NAME))) {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(in));
            String s = null;
            while ((s = bufferedReader.readLine()) != null) {
                System.out.println(s);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testBufferedWriter() throws FileNotFoundException {
        OutputStream out = new FileOutputStream(FILE_NAME, true);
        OutputStreamWriter writer = new OutputStreamWriter(out);
        try (BufferedWriter bufferedWriter = new BufferedWriter(writer)) {
            bufferedWriter.write("Hello BufferedWriter.");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static class Person implements Serializable {
        private String name;
        private Integer age;
        private transient String pawd;

        public Person() {
        }

        public Person(String name, Integer age, String pawd) {
            this.name = name;
            this.age = age;
            this.pawd = pawd;
        }

        public String getPawd() {
            return pawd;
        }

        public void setPawd(String pawd) {
            this.pawd = pawd;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Integer getAge() {
            return age;
        }

        public void setAge(Integer age) {
            this.age = age;
        }

        @Override
        public String toString() {
            return "Person{" +
                    "name='" + name + '\'' +
                    ", age=" + age +
                    ", pawd='" + pawd + '\'' +
                    '}';
        }
    }


    /**
     * 序列化流
     */
    @Test
    public void testObjectOutputStream() {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(SERIALIZED_FILE_NAME))) {
            out.writeObject(new IOTest.Person("拉格朗日", 23, "1246"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testObjectInputStream() {
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(SERIALIZED_FILE_NAME))) {
            Person person = (Person) in.readObject();
            System.out.println(person);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testAccess() {
        try (RandomAccessFile randomAccessFile = new RandomAccessFile(FILE_NAME, "rw")) {
            FileChannel channel = randomAccessFile.getChannel();
            long size = channel.size();
            randomAccessFile.setLength(size);
            channel.position(size);
            long filePointer = randomAccessFile.getFilePointer();

            randomAccessFile.write("llo".getBytes());
            System.out.println(size);
            System.out.println(filePointer);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testBio() {
        class AccessFile implements Runnable {

            @Override
            public void run() {
                try {
                    OutputStream out = new FileOutputStream(FILE_NAME);
                    out.write("aaaaaa".getBytes());
                    Thread.sleep(3000);
                    out.write("aaaaaa".getBytes());
                    out.flush();
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

        Thread thread0 = new Thread(new AccessFile());
        Thread thread1 = new Thread(new AccessFile());
        thread0.start();
        thread1.start();

        while (true) {

        }
    }


}
