package com.sreviewonly.board.service;

import com.sreviewonly.board.entites.enums.PREFERSEX;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public interface FileService {

    public void signUpRegister(String email, String password, String nickname, MultipartFile profile_pic, MultipartFile background_pic, PREFERSEX prefersex);

}
