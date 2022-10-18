package com.sreviewonly.board.service;

import com.sreviewonly.board.dto.UserDTO;
import com.sreviewonly.board.entites.User;
import com.sreviewonly.board.entites.enums.PREFERSEX;
import com.sreviewonly.board.repositories.UserRepository;
import com.sreviewonly.board.util.FileNameRandomization;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class FileServiceImpl implements FileService{

    @Autowired
    private UserRepository userRepository;
    @Override
    public void signUpRegister(String email, String password, String nickname, MultipartFile profile_pic, MultipartFile background_pic, PREFERSEX prefersex) {
        String profilePictureNewName = FileNameRandomization.uploadFileWithUUID(profile_pic);
        String backgroundPictureNewName = FileNameRandomization.uploadFileWithUUID(background_pic);
        UserDTO userDTO = new UserDTO();
        userDTO.setEmail(email);
        userDTO.setPassword(password);
        userDTO.setNickname(nickname);
        userDTO.setProfile_pic(profilePictureNewName);
        userDTO.setBackground_pic(backgroundPictureNewName);
        userDTO.setOtherElement();

        User user = new User.UserBuilder(userDTO).build();

        userRepository.save(user);
    }
}
