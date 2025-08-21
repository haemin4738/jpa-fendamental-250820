package com.back.domain.post.post.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity // 아래 구조대로 DB 테이블(컬럼)을 만들어야 한다.
@NoArgsConstructor // 인자 없는 생성자 함수 public Post() {}
public class Post {
    @Id // PK
    @GeneratedValue(strategy = GenerationType.IDENTITY) // AUTO_INCREMENT
    private int id; // INT
    private String title; // VARCHAR(255)

    @Column(columnDefinition = "TEXT") // TEXT 타입으로 설정
    private String content; // TEXT

    public Post(String title, String content) {
        this.title = title;
        this.content = content;
    }
}
