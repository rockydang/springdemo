package com.mogujie.service.springdemo.common.callback.example2;


/**
 * Created by yanxiao on 16/4/14.
 */
public class Li {

    public void executeMessage(CallBackInterface2 call, String message) {
        try {
            Thread.sleep(1000 * 2);
            String result = "kobe退役。。。【2016-4-14】";
            call.solve(result);
        } catch (Exception e) {
            System.out.println("error..."+e.getLocalizedMessage());
        }
    }
}
