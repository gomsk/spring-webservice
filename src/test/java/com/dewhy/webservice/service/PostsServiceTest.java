package com.dewhy.webservice.service;

import com.dewhy.webservice.domain.posts.PostRepository;
import com.dewhy.webservice.domain.posts.Posts;
import com.dewhy.webservice.dto.posts.PostSaveRequestDto;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;


@RunWith(SpringRunner.class)
@SpringBootTest
public class PostsServiceTest {

    @Autowired
    private PostsService postsService;

    @Autowired
    private PostRepository postRepository;

    @After
    public void cleanup(){
        postRepository.deleteAll();
    }

    @Test
    public void save() {
        //given
        PostSaveRequestDto dto = PostSaveRequestDto.builder()
                .author("author1")
                .content("test1")
                .title("title1")
                .build();
        //when
        postsService.save(dto);
        Posts posts = postRepository.findAll().get(2);
        assertThat(posts.getAuthor()).isEqualTo(dto.getAuthor());
        assertThat(posts.getContent()).isEqualTo(dto.getContent());
        assertThat(posts.getTitle()).isEqualTo(dto.getTitle());
    }

}