package com.sreviewonly.board.repositories;

import com.sreviewonly.board.entites.Hashtag;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.stereotype.Repository;

@Repository

public interface HashtagRepository extends JpaRepository<Hashtag,Long> {
}
