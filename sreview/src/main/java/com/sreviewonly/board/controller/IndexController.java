package com.sreviewonly.board.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@Controller
public class IndexController {

    //특정 mapping에 도착하면, return값으로 templates의 절대 경로를 돌려줌.

    @RequestMapping(value = "index/signin",method = RequestMethod.GET)
    public String goSignin(HttpServletRequest request){
        return "signin";
    }

    @RequestMapping(value = "index",method = RequestMethod.GET)
    public String goIndex(HttpServletRequest request){
        return "index";
    }



}
