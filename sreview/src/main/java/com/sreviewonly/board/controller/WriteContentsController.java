package com.sreviewonly.board.controller;

import com.sreviewonly.board.dto.UserDTO;
import com.sreviewonly.board.entites.enums.PREFERSEX;
import com.sreviewonly.board.service.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@Controller
@SessionAttributes("user")
public class WriteContentsController {


    @Autowired
    private FileService fileService;

    @ModelAttribute("user")
    public UserDTO setUserDTO(){
        return new UserDTO();
    }

    @RequestMapping(value = "review_write_page",method = RequestMethod.GET)
    public String getReviewWritePage(@ModelAttribute("user") UserDTO userDTO){
        if(userDTO.getId()==0L)
            return "redirect:signin";

        return "review_write_page";
    }

    @RequestMapping(value = "review_write",method = RequestMethod.POST)
    public String writeReview(@ModelAttribute("user") UserDTO userDTO,
                              @RequestParam(name = "main_pic")MultipartFile profilePic,
                              @RequestParam(name="title")String title,
                              @RequestParam(name="content")String content,
                              @RequestParam(name="star") double star){
        fileService.insertReview(profilePic,title,content,star,userDTO);
        StringBuilder sb = new StringBuilder();
        String sex = PREFERSEX.changePreferSexToString(userDTO.getPrefersex());
        sb.append("redirect:review_main").append("?prefersex=").append(sex).append("&page=1");
        return sb.toString();
    }
}
