package com.sreviewonly.board.service;

import com.sreviewonly.board.dto.ReviewDTO;
import com.sreviewonly.board.entites.Review;
import com.sreviewonly.board.entites.enums.PREFERSEX;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public interface ReviewListPageService {

    public List<ReviewDTO> findReviewByPreferSex(PREFERSEX prefersex, Map<String,Integer> pageMap, int page);

    public ReviewDTO findReviewById(long id);

}
