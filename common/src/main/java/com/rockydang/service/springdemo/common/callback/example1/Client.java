package com.rockydang.service.springdemo.common.callback.example1;

/**
 * Created by yanxiao on 16/4/14.
 */
public class Client {
    public static void main(String[] args) {
        Employee emp = new Employee();
        //将回调对象（上层对象）传入，注册
        emp.setCallBack(new Boss());
        //开启控制器对象运行
        emp.doSome();
    }

}
