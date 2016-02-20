package com.leon.controller;

import com.alibaba.fastjson.JSON;
import com.leon.model.User;
import com.leon.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by Administrator.
 * User: Leon
 * 2016/2/1
 */
@Controller
@RequestMapping(value = "/index")
public class IndexController {
    @Autowired
    private TestService testService;


    @RequestMapping(value = "/index.do")
    @ResponseBody
    public String index(HttpServletRequest request) throws Exception{
        String result = "";
        User user = testService.getUser(1);
        result = JSON.toJSONString(user);
        return  result;
    }

    @RequestMapping(value = "/fecth")
    @ResponseBody
    public String fecth(HttpServletRequest request) throws Exception{
        String result = "success";
        testService.test();
        return result;
    }

    @RequestMapping(value = "jianli")
    public String jianli(HttpServletRequest request) throws Exception{
        return "jianli";
    }

}
