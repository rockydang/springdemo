package com.rockydang.service.springdemo.service.topic.impl;

import com.rockydang.service.springdemo.service.topic.TopicService;
import org.springframework.stereotype.Service;

/**
 * Created by yanxiao on 16/4/12.
 */
//@Component
//@Service(value = "topicService1")
@Service
public class TopicServiceImpl implements TopicService {

    public String queryTopicInfo(String topicId) {

        System.out.println("1111111111");
        return "123";
    }

}
