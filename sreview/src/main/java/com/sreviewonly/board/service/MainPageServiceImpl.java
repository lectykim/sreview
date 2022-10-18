package com.sreviewonly.board.service;

import com.sreviewonly.board.dto.ProductDTO;
import com.sreviewonly.board.dto.UserDTO;
import com.sreviewonly.board.entites.Product;
import com.sreviewonly.board.entites.User;
import com.sreviewonly.board.repositories.ProductRepository;
import com.sreviewonly.board.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MainPageServiceImpl implements MainPageService{

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private UserRepository userRepository;

    @Override
    public List<ProductDTO> findTop5Product() {
        List<Product> productList = productRepository.findTop5ByOrderByIdDesc();
        List<ProductDTO> productDTOList = new ArrayList<>();
        ProductDTO productDTO;
        for(Product product:productList){
            productDTO = new ProductDTO(product);
            productDTOList.add(productDTO);
        }
        return productDTOList;
    }

    @Override
    public List<UserDTO> findTop5User() {
        List<User> userList = userRepository.findTop5ByOrderByIdDesc();
        List<UserDTO> userDTOList = new ArrayList<>();
        UserDTO userDTO;
        for(User user:userList){
            userDTO = new UserDTO(user);;
            userDTOList.add(userDTO);
        }

        return userDTOList;

    }
}
