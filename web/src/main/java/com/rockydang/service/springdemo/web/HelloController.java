package com.rockydang.service.springdemo.web;

import com.rockydang.service.springdemo.service.TopicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

/**
 * Created by yanxiao on 16/4/6.
 */
@Controller(value = "helloController")
@RequestMapping("/hello")
public class HelloController {

    //@Resource(name = "topicService1")  //service必须要指定名称才可以
    //@Resource    //

    @Autowired
    TopicService topicService;

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    String dateTime;

    /**
     * 查询文章列表
     *
     * @param request
     * @return
     */
    @SuppressWarnings("finally")
    @RequestMapping(value = "test")
    @ResponseBody
    public String test(HttpServletRequest request) {

        String id = topicService.queryTopicInfo("1");
        System.out.println("id===" + id);
        try {
            ServletContext servletContext = request.getSession().getServletContext();
            WebApplicationContext webApplicationContext1 = WebApplicationContextUtils.getWebApplicationContext(servletContext, "org.springframework.web.servlet.FrameworkServlet.CONTEXT.spring");

            //1.通过子容器获取子容器的bean;
            Object childBean = webApplicationContext1.getBean("testController");
            if (childBean != null) {
                System.out.println("childBean====" + childBean);
            }

            //2.通过子容器获取父容器的bean
            Object parentBean = webApplicationContext1.getBean("topicService");
            if (parentBean != null) {
                System.out.println("parentBean====" + parentBean);
            }

            topicService.testGetBean(webApplicationContext1,request);

        } catch (Exception e) {
            e.getLocalizedMessage();
        }
        return "id=" + id;
    }

    @SuppressWarnings("finally")
    @RequestMapping(value = "testResponse")

    @ResponseBody
    public Boolean testResponse(ModelMap modelMap, HttpServletRequest request) {

        System.out.println("testResponse ....");
        return true;
    }
}
