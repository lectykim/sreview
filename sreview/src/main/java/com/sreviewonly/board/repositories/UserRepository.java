package com.sreviewonly.board.repositories;

import com.sreviewonly.board.entites.User;
import com.sreviewonly.board.entites.enums.VIPRANK;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {

    @Query("SELECT u FROM User u join fetch u.reviews")
    public List<User> findAllWithReviewUsingFetchJoin();

    public List<User> findTop5ByOrderByIdAsc();



}
