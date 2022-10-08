package com.sreviewonly.board.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@Controller
public class IndexController {

    //특정 mapping에 도착하면, return값으로 templates의 절대 경로를 돌려줌.

    @RequestMapping(value = "signin",method = RequestMethod.GET)
    public String goSignin(HttpServletRequest request){
        return "signin";
    }

    @RequestMapping(value = "sign_in_part_1",method = RequestMethod.GET)
    public String goSigninPart1(HttpServletRequest request){
        return "sign_in_part_1";
    }

    @RequestMapping(value = "review_find_by_product",method = RequestMethod.GET)
    public String goReviewProduct(HttpServletRequest request){
        return "review_find_by_product";
    }

    @RequestMapping(value = "review_find_by_user",method = RequestMethod.GET)
    public String goReviewUser(HttpServletRequest request){
        return "review_find_by_user";
    }

    @RequestMapping(value = "review_view",method = RequestMethod.GET)
    public String goReviewView(HttpServletRequest request){
        return "review_view";
    }

    @RequestMapping(value = "review_write_page",method = RequestMethod.GET)
    public String goReviewWritePage(HttpServletRequest request){
        return "review_write_page";
    }

    @RequestMapping(value = "congratulation",method = RequestMethod.GET)
    public String goCongratulation(HttpServletRequest request){
        return "congratulation";
    }

    @RequestMapping(value = "counsel_page",method = RequestMethod.GET)
    public String goCounsel(HttpServletRequest request){
        return "counsel_page";
    }


    @RequestMapping(value = "counsel_management_page",method = RequestMethod.GET)
    public String goCounselManage(HttpServletRequest request){
        return "counsel_management_page";
    }


    @RequestMapping(value = "index",method = RequestMethod.GET)
    public String goIndex(HttpServletRequest request){
        return "index";
    }

    @RequestMapping(value = "",method = RequestMethod.GET)
    public String goAll(HttpServletRequest request){
        return "index";
    }



}
