package com.sreviewonly.board.controller;

import com.sreviewonly.board.dto.UserDTO;
import com.sreviewonly.board.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;

@Controller
@SessionAttributes("user")
public class LoginController {


    @Autowired
    private UserService userService;


    @RequestMapping(value = "/login",method = RequestMethod.GET)
    public void loginView(){

    }

    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public String login(@RequestParam(name = "email")String email,@RequestParam(name="password")String password, Model model){
        UserDTO userDTO = userService.getUserDTO(email,password);

        if(userDTO!=null){
            model.addAttribute("user",userDTO);
            return "redirect:";

        }else
            return "redirect:login";

    }

    @RequestMapping(value = "/logout",method = RequestMethod.GET)
    public String logout(SessionStatus status){
        status.setComplete();
        return "redirect:";
    }

}
