package com.sreviewonly.board.repositories;

import com.sreviewonly.board.entites.Product;
import com.sreviewonly.board.entites.User;
import com.sreviewonly.board.entites.enums.PREFERSEX;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository

public interface ProductRepository extends JpaRepository<Product,Long> {

    public List<Product> findTop5ByOrderByIdDesc();


    public List<Product> findProductByProductPreferSex(PREFERSEX prefersex);
}
