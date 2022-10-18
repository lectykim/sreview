package com.sreviewonly.board.dto;

import com.sreviewonly.board.entites.ReviewToHashtag;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ReviewToHashtagDTO {

    private long id;

    private long reviewId;

    private long hashtagId;

    private void EntityToDTO(ReviewToHashtag review){
        this.id=review.getId();
        this.reviewId = review.getReviewId();
        this.hashtagId = review.getHashtagId();
    }
}
