package com.rockydang.service.springdemo.service;

import org.springframework.web.context.WebApplicationContext;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by yanxiao on 16/4/12.
 */
public interface TopicService {

    //    @UseLog(title = "123", action = "add", isSaveRequestData = false)
    String queryTopicInfo(String topicId);

    String getScope(String str);

    String testGetBean(WebApplicationContext childApplicationContext,HttpServletRequest request);
}
