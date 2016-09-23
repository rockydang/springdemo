package com.rockydang.service.springdemo.web;

import com.rockydang.service.springdemo.service.TopicService;
import com.rockydang.service.springdemo.web.bean.BeanTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by yanxiao on 16/4/6.
 */
@Controller
//@RequestMapping("/hello")
public class HelloController {

    //@Resource(name = "topicService1")  //service必须要指定名称才可以
    //@Resource    //

    @Autowired     //自动装配
    TopicService topicService;

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    String dateTime;


    /**
     * 查询文章列表
     *
     * @param modelMap
     * @param request
     * @return
     */
    @SuppressWarnings("finally")
    @RequestMapping(value = "test")
    public ModelAndView test(ModelMap modelMap, HttpServletRequest request,BeanTest beanTest) {

        String id = topicService.queryTopicInfo("1");
        System.out.println("id==="+id);

        modelMap.put("form",id);
        modelMap.addAttribute("fdfdfd","1233");

        return new ModelAndView("/topic/topic_list");
    }


    @SuppressWarnings("finally")
    @RequestMapping(value = "testResponse")
    public @ResponseBody Boolean testResponse(ModelMap modelMap, HttpServletRequest request) {

        System.out.println("testResponse ....");

        return true;
    }
}
