package com.sreviewonly.board.entites;

import com.sreviewonly.board.entites.enums.PREFERSEX;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter

@EntityListeners(AuditingEntityListener.class)
@EntityScan
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_id")
    private long id;

    private String productPic;

    private String productName;

    private String productShop;

    private Long productPrice;

    private PREFERSEX productPreferSex;

    @OneToMany(mappedBy = "product",cascade = CascadeType.ALL)
    private List<Review> reviewList;




}
