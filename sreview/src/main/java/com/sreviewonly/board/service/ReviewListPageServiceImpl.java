package com.sreviewonly.board.service;

import com.sreviewonly.board.dto.CommentDTO;
import com.sreviewonly.board.dto.ProductDTO;
import com.sreviewonly.board.dto.ReviewDTO;
import com.sreviewonly.board.dto.UserDTO;
import com.sreviewonly.board.entites.Review;
import com.sreviewonly.board.entites.enums.PREFERSEX;
import com.sreviewonly.board.repositories.ReviewRepository;
import com.sreviewonly.board.util.Pagination;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class ReviewListPageServiceImpl implements ReviewListPageService{

    @Autowired
    public ReviewRepository reviewRepository;



    @Override
    public List<ReviewDTO> findReviewByPreferSex(PREFERSEX prefersex,Map<String,Integer> pageMap, int page) {



        PageRequest pageRequest =PageRequest.of(page-1,15);

        Page<Review> reviewPage = reviewRepository.findReviewByprefersexOrderByIdDesc(prefersex,pageRequest);

        List<ReviewDTO> reviewDTOList = new ArrayList<>();
        ReviewDTO reviewDTO;
        for(Review review:reviewPage){
            reviewDTO = new ReviewDTO(review);
            if(review.getUser()!=null){

            }

            reviewDTOList.add(reviewDTO);
        }
        return reviewDTOList;
    }

    @Override
    public ReviewDTO findReviewById(long id) {
        Review review = reviewRepository.findById(id).get();
        ReviewDTO reviewDTO = new ReviewDTO(review);
        try{
            if(review.getUser()!=null){
                reviewDTO.setUserDTO(new UserDTO(review.getUser()));
            }
            if(review.getProduct()!=null){
                reviewDTO.setProductDTO(new ProductDTO(review.getProduct()));
            }
            if(review.getComment()!=null){
                reviewDTO.setCommentDTO(new CommentDTO(review.getComment()));
            }
        } catch (NullPointerException e){
            System.out.println("----- review Attribution Error ----");
            System.out.println(e);
        }
        return reviewDTO;
    }
}
