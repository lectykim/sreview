package com.sreviewonly.board.service;

import com.sreviewonly.board.dto.ProductDTO;
import com.sreviewonly.board.dto.UserDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface MainPageService {

    public List<ProductDTO> findTop5Product();

    public List<UserDTO> findTop5User();
}
