package com.rockydang.service.springdemo.common.el;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.simpleEL.eval.DefaultExpressEvalService;
import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by yanxiao on 2017/1/18.
 */
public class ExpressUtilsTest {

    @Test
    public void testExpress() {

        try {
            //integer
       /*
        DefaultExpressEvalService service = new DefaultExpressEvalService();
        service.regsiterVariant(Integer.TYPE, "a", "b"); // 注册两个类型为Integer的变量
        Map ctx = new HashMap();
        ctx.put("a", 3);
        ctx.put("b", 4);
        Assert.assertEquals(7, service.eval(ctx, "@a + @b"));*/

            //object
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("a", "1");
            jsonObject.put("b", "2");
            jsonObject.put("c", "3");


            DefaultExpressEvalService service = new DefaultExpressEvalService();
            service.regsiterVariant(JSONObject.class, "object"); // 注册两个类型为Integer的变量
            Map ctx = new HashMap();
            ctx.put("object", jsonObject);

            Assert.assertEquals("1d",service.eval(ctx, "@object.get(\"a\")"));
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
