package com.rockydang.service.springdemo.service;

import com.rockydang.service.springdemo.common.annotation.uselog.UseLog;

/**
 * Created by yanxiao on 16/4/12.
 */
public interface TopicService {

    @UseLog(title = "123", action = "add", isSaveRequestData = false)
    String queryTopicInfo(String topicId);

    String getScope(String str);
}
