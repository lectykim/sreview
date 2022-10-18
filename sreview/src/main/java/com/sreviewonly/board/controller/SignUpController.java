package com.sreviewonly.board.controller;

import com.sreviewonly.board.entites.enums.PREFERSEX;
import com.sreviewonly.board.service.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;



@Controller
public class SignUpController {

    @Autowired
    private FileService fileService;

    @RequestMapping(value = "signin",method = RequestMethod.GET)
    public String goSignin(HttpServletRequest request){
        return "signin";

    }

    @RequestMapping(value = "sign_up_part_1",method = RequestMethod.GET)
    public String goSignupPart1(HttpServletRequest request){
        return "sign_up_part_1";

    }

    @RequestMapping(value = "sign_up_final",method = RequestMethod.POST)
    public String receiveSignup(@RequestParam String email,
                                @RequestParam String password,
                                @RequestParam String passwordCheck,
                                @RequestParam String nickname,
                                @RequestParam(name = "profile_pic") MultipartFile profilePicture,
                                @RequestParam(name = "background_pic") MultipartFile backgroundPicture,
                                @RequestParam(name = "prefersex") String sex){

        PREFERSEX prefersex = PREFERSEX.changeStringToPreferSex(sex);
        fileService.signUpRegister(email,password,nickname,profilePicture,backgroundPicture,prefersex);

        //Test 단계에선 void
        return "redirect:";
    }

}
