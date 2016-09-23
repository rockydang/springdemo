package com.rockydang.service.springdemo.service.impl;

import com.rockydang.service.springdemo.common.annotation.uselog.UseLog;
import com.rockydang.service.springdemo.service.GuavaLocalLoadService;
import com.rockydang.service.springdemo.service.TopicService;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by yanxiao on 16/4/12.
 */
//@Component
//@Service(value = "topicService1")

@Service(value = "topicService")
@Scope("prototype")
public class TopicServiceImpl implements TopicService {

    @Resource
    private GuavaLocalLoadService guavaLocalLoadService;

    @UseLog(title = "123", action = "add", isSaveRequestData = false)
    public String queryTopicInfo(String topicId) {
//        System.out.println("TopicServiceImpl.queryTopicInfo start...");

//        System.out.println("TopicServiceImpl.guavaLocalLoadService:::"+guavaLocalLoadService.testScope());
//        System.out.println("TopicServiceImpl.guavaLocalLoadService:::" + guavaLocalLoadService);
        return "topic:::" + topicId;
    }

    public String getScope(String str) {

        System.out.println("guavaLocalLoadService::" + guavaLocalLoadService);
        return "topic:::" + str;
    }
}
