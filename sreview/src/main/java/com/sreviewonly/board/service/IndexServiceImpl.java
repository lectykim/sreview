package com.sreviewonly.board.service;

import com.sreviewonly.board.entites.User;
import com.sreviewonly.board.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
public class IndexServiceImpl implements IndexService {

    @Autowired
    public UserRepository userRepository;

    @Override
    public Page<User> getUsersOrderByPk() {
        PageRequest pageRequest = PageRequest.of(0, 5);
        return userRepository.findAll(pageRequest);
    }
}
