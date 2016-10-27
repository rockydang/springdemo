package com.rockydang.service.springdemo.service.impl;

import com.rockydang.service.springdemo.common.cache.guava.TestListKey;
import com.rockydang.service.springdemo.common.cache.guava.TestQuery;
import com.rockydang.service.springdemo.service.GuavaLocalLoadService;
import org.junit.Test;

/**
 * 文件描述。
 *
 * @author yanxiao
 * @since 2016年08月22日 22:51
 */
public class GuavaLocalLoadServiceImplTest extends AbstractBootStrapTest {
    @Test
    public void testQueryContentLocalCache() throws Exception {
        GuavaLocalLoadService guavaLocalLoadService = (GuavaLocalLoadService) context.getBean("guavaLocalLoadService");
        if (guavaLocalLoadService != null) {

            //a
            TestQuery testQuery = new TestQuery();
            testQuery.setName("123");
            TestListKey testListKey = new TestListKey("a", testQuery);
            String str1 = guavaLocalLoadService.queryContentFromLocalCache(testListKey);
            System.out.println("Str1=="+str1);

            //b
            String str2 = guavaLocalLoadService.queryContentFromLocalCache(testListKey);
            System.out.println("Str2=="+str2);

            //d
            TestQuery testQuery1 = new TestQuery();
            testQuery1.setName("123");
            TestListKey testListKey1 = new TestListKey("b", testQuery);
            String str4 = guavaLocalLoadService.queryContentFromLocalCache(testListKey1);
            System.out.println("Str4=="+str4);

            //c
            String str3 = guavaLocalLoadService.queryContentFromLocalCache(testListKey);
            System.out.println("Str3=="+str3);
        }
    }
}