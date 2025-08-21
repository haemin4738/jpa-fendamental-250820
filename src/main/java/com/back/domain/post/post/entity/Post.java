package com.back.domain.post.post.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;

@Getter
@Setter
@Entity // 아래 구조대로 DB 테이블(컬럼)을 만들어야 한다
@ToString// .
// @NoArgsConstructor // 인자 없는 생성자 함수 public Post() {}
public class Post {
    @Id // PK
    @GeneratedValue(strategy = GenerationType.IDENTITY) // AUTO_INCREMENT
    private int id; // INT
    private LocalDateTime createDate;
    private LocalDateTime modifyDate;
    private final String title; // VARCHAR(255)
    @Column(columnDefinition = "TEXT")
    private final String content; // TEXT

    public Post (String title, String content) {
        this.createDate = LocalDateTime.now();
        this.modifyDate = this.createDate;
        this.title = title;
        this.content = content;
    }

    public Post() {
        this("", "");
    }
}
