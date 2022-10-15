package com.sreviewonly.board.entites;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter
@EntityListeners(AuditingEntityListener.class)
@EntityScan
public class Counsel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String title;

    private String content;

    private String email;

    @CreatedDate
    private LocalDateTime createdDate;

    @Builder
    public Counsel(String title,String content,String email){
        this.title=title;
        this.content=content;
        this.email=email;
    }

    public Counsel() {

    }
}
