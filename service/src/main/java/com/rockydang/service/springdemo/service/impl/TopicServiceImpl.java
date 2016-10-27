package com.rockydang.service.springdemo.service.impl;

import com.rockydang.service.springdemo.service.GuavaLocalLoadService;
import com.rockydang.service.springdemo.service.TopicService;
import com.rockydang.service.springdemo.service.springevent.SpringContextUtil;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.annotation.Resource;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

/**
 * Created by yanxiao on 16/4/12.
 */
@Service(value = "topicService")
@Scope("prototype")
public class TopicServiceImpl implements TopicService {

    @Resource
    private GuavaLocalLoadService guavaLocalLoadService;

    //    @UseLog(title = "123", action = "add", isSaveRequestData = false)
    public String queryTopicInfo(String topicId) {
        System.out.println("TopicServiceImpl.queryTopicInfo....");

        return "topic:::" + topicId;
    }

    public String getScope(String str) {

        System.out.println("guavaLocalLoadService::" + guavaLocalLoadService);
        return "topic:::" + str;
    }

    public String testGetBean(WebApplicationContext childApplicationContext, HttpServletRequest request) {

        try {
            try {
                //1.通过父容器获取子容器的bean;
                Object childBean1 = SpringContextUtil.getBean("testController");
                if (childBean1 != null) {
                    System.out.println("childBean1====" + childBean1);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }

            //4.通过父容器获取父容器的bean
            Object parentBean1 = SpringContextUtil.getBean("topicService");
            if (parentBean1 != null) {
                System.out.println("parentBean1====" + parentBean1);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "testGetBean";
    }
}
