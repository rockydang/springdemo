package com.rockydang.service.springdemo.common.pattern.decorator.inputstream;

import java.io.*;

/**
 * Created by yanxiao on 2018/5/8.
 */
public class InputTest {

    public static void main(String[] args) throws IOException {
        int c;
        StringBuffer sb = new StringBuffer();
        try {
            //这里用了两个装饰者，分别是BufferedInputStream和我们的UpperFirstWordInputStream
            InputStream in
                    = new UpperFirstWordInputStream(
                    new BufferedInputStream(new FileInputStream("/Users/yanxiao/test.txt")));
            while ((c = in.read()) >= 0) {
                sb.append((char) c);
            }
            System.out.println(sb);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
