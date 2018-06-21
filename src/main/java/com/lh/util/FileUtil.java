package com.lh.util;

import java.io.*;

public class FileUtil {
    public static String read(String fileName) {
        StringBuilder result = new StringBuilder();

        try (InputStream inputStream = new FileInputStream(fileName);
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
            BufferedReader reader = new BufferedReader(inputStreamReader)) {

            String str;
            while ((str = reader.readLine()) != null) {
                result.append(str + "\n");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return result.toString();
    }

    public static void main(String[] args) {
        String read = read("data.txt");
        System.out.println(read);
    }
}
