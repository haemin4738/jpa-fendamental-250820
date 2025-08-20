package com.back.global.initData;


import com.back.domain.post.post.entity.Post;
import com.back.domain.post.post.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BaseInitData {

    @Autowired
    private PostRepository postRepository;

    @Bean
    ApplicationRunner baseInitDataApplicationRunner() {
        return args -> {
            if(postRepository.count() >0) {
                return; // 데이터가 이미 존재하면 초기화하지 않음
            }

            Post post = new Post();
            post.setTitle("제목 1");
            postRepository.save(post);
            // INSERT INTO post SET title = '제목 1';

            Post post2 = new Post();
            post2.setTitle("제목 2");
            postRepository.save(post2);

            System.out.println("기본 데이터가 초기화 되었습니다.");
        };
    }
}