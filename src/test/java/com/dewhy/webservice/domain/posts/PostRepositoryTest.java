package com.dewhy.webservice.domain.posts;

import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDateTime;
import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PostRepositoryTest {

    @Autowired
    PostRepository postRepository;

    @After
    public void clenup(){
        postRepository.deleteAll();
    }

    @Test
    public void postSave(){
        //given
        postRepository.save(Posts.builder()
                .title("테스트 게시글")
                .content("테스트 본문")
                .author("dewhy@gmail.com")
                .build()
        );
        //when
        List<Posts> postsList = postRepository.findAll();

        //then
        Posts posts = postsList.get(0);
        assertThat(posts.getTitle(),is("테스트 게시글"));
        assertThat(posts.getContent(),is("테스트 본문"));

    }

    @Test
    public void BaseEntityRegister(){
        //given
        LocalDateTime now = LocalDateTime.now();
        postRepository.save(Posts.builder()
                .title("test1")
                .content("cotent1")
                .author("autho1")
                .build());
        //when
        List<Posts> poostList = postRepository.findAll();

        //then
        Posts posts = poostList.get(0);
        assertTrue(posts.getCreatedDate().isAfter(now));
        assertTrue(posts.getModifiedDate().isAfter(now));
    }

}