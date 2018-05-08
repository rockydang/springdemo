package com.rockydang.service.springdemo.common.pattern.decorator.inputstream;

import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * 第一个字母大写
 * <p>
 * Created by yanxiao on 2018/5/8.
 */
public class UpperFirstWordInputStream extends FilterInputStream{

    private int cBefore = 32;

    protected UpperFirstWordInputStream(InputStream in) {
        //由于FilterInputStream已经保存了装饰对象的引用，这里直接调用super即可
        super(in);
    }

    @Override
    public int read() throws IOException {
        //根据前一个字符是否是空格来判断是否要大写
        int c = super.read();
        if(cBefore == 32)
        {
            cBefore = c;
            return (c == -1 ? c: Character.toUpperCase((char) c));
        }else{
            cBefore = c;
            return c;
        }
    }
}
