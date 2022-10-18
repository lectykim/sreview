package com.sreviewonly.board.entites;

import com.sreviewonly.board.entites.enums.PREFERSEX;
import lombok.*;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter


@EntityListeners(AuditingEntityListener.class)
@EntityScan
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private long id;

    private String productPic;

    private String name;

    private String shopName;

    private long price;

    private String shopLink;

    private PREFERSEX preferSex;

    @OneToMany(mappedBy = "product",cascade = CascadeType.ALL)
    private List<Review> reviewList;

    @Builder
    public Product(String productPic,String name, String shopName,long price,String shopLink,PREFERSEX preferSex){
        this.productPic=productPic;
        this.name=name;
        this.shopName=shopName;
        this.price=price;
        this.shopLink=shopLink;
        this.preferSex=preferSex;
    }




    public Product() {

    }
}
