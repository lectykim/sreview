package com.sreviewonly.board.service;

import com.sreviewonly.board.dto.UserDTO;
import org.springframework.stereotype.Service;

@Service
public interface UserService {
    public UserDTO getUserDTO(String email,String password);
}
