package com.sreviewonly.board.service;

import com.sreviewonly.board.entites.User;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;


public interface IndexService {
    public Page<User> getUsersOrderByPk();
}
