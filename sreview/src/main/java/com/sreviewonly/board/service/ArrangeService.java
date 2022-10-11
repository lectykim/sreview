package com.sreviewonly.board.service;

import com.sreviewonly.board.entites.Product;
import com.sreviewonly.board.entites.enums.PREFERSEX;

import java.util.List;

public interface ArrangeService {



    List<Product> ArrangeReviewToPreferSex(PREFERSEX prefersex);
}
