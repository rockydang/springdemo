package com.rockydang.service.springdemo.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by yanxiao on 16/4/6.
 */
@Controller(value = "testController")
@RequestMapping("/test")
public class TestController {

    /**
     * 查询文章列表
     *
     * @param request
     * @return
     */
    @SuppressWarnings("finally")
    @RequestMapping(value = "test11")
    @ResponseBody
    public String test11(HttpServletRequest request) {

        String id = request.getParameter("id");
        System.out.println("id==id=" + id);
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
