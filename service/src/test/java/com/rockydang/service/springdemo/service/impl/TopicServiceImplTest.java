package com.rockydang.service.springdemo.service.impl;

import com.rockydang.service.springdemo.service.GuavaLocalLoadService;
import com.rockydang.service.springdemo.service.TopicService;
import org.junit.Test;

/**
 * Created by yanxiao on 16/4/26.
 */
public class TopicServiceImplTest extends AbstractBootStrapTest {

    @Test
    public void testQueryTopicInfo() throws Exception {

//        TopicService topicService = context.getBean(TopicService.class);

        TopicService topicService = (TopicService) context.getBean("topicService");
        System.out.println("123");
        topicService.queryTopicInfo("123");
        System.out.println("123");
    }


    @Test
    public void testScope() throws Exception {

//        TopicService topicService = (TopicService) context.getBean("topicService");
//        TopicService topicService = context.getBean(TopicService.class);
        TopicService topicService = context.getBean("topicService",TopicService.class);

        TopicService topicService1 = (TopicService) context.getBean("topicService");

//        System.out.println("topicService==" + topicService + ";" +topicService.getScope("123") );
//        System.out.println("topicService1==" + topicService1 + ";" + topicService1.getScope("234"));

        topicService.getScope("123");
        topicService1.getScope("234");

        GuavaLocalLoadService guavaLocalLoadService = (GuavaLocalLoadService) context.getBean("guavaLocalLoadService");
        GuavaLocalLoadService guavaLocalLoadService1 = (GuavaLocalLoadService) context.getBean("guavaLocalLoadService");
        System.out.println("guavaLocalLoadService=" + guavaLocalLoadService);
        System.out.println("guavaLocalLoadService1=" + guavaLocalLoadService1);
    }


    @Test
    public void testIoCSort() throws Exception {
        System.out.println("testIoCSort...");
    }

}