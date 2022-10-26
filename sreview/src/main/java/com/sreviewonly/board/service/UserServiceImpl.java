package com.sreviewonly.board.service;

import com.sreviewonly.board.dto.UserDTO;
import com.sreviewonly.board.entites.User;
import com.sreviewonly.board.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserRepository userRepository;

    public UserDTO getUserDTO(String email,String password){
        User findUser = userRepository.findByEmail(email);
        if(findUser!=null && findUser.getPassword().equals(password)){
            return new UserDTO(findUser);
        }else
            return null;



    }

    @Override
    public UserDTO findUserDTOById(String email) {
        return null;
    }

}
