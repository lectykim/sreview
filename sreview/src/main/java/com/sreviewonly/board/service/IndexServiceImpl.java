package com.sreviewonly.board.service;

import com.sreviewonly.board.entites.Product;
import com.sreviewonly.board.entites.User;
import com.sreviewonly.board.repositories.ProductRepository;
import com.sreviewonly.board.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IndexServiceImpl implements IndexService {

    @Autowired
    public UserRepository userRepository;

    @Autowired
    public ProductRepository productRepository;

    @Override
    public List<User> getUserMain() {
        return userRepository.findTop5ByOrderByIdAsc();
    }

    @Override
    public List<Product> getProductMain() {
        return productRepository.findTop5ByOrderByIdDesc();
    }
}
