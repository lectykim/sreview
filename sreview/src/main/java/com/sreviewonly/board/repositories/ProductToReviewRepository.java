package com.sreviewonly.board.repositories;

import com.sreviewonly.board.entites.Product;
import com.sreviewonly.board.entites.ProductToReview;
import com.sreviewonly.board.entites.Review;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductToReviewRepository extends JpaRepository<ProductToReview,Long> {

    public List<ProductToReview> findReviewByProduct(Product product);

    public List<ProductToReview> findProductByReview(Review review);

    public ProductToReview findFirstByReview(Review review);

}
