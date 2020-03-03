package com.liyutao.dp.adapter;

import java.io.*;

/**
 * @auther lytstart
 * @create 2020-02-28-13:03
 * ClassReader和ClassWriter连上的话 需要复制，中间需要加一个转接。
 */
public class adapter {
    public static void main(String[] args) throws Exception {
        FileInputStream fis = new FileInputStream("d:/test.txt");
        InputStreamReader isr = new InputStreamReader(fis);
        BufferedReader br = new BufferedReader(isr);
        String line = br.readLine();
        while (line != null && !line.equals("")) {
            System.out.println(line);
        }
        br.close();
    }
}
