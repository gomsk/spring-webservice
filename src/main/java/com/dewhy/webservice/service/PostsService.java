package com.dewhy.webservice.service;


import com.dewhy.webservice.domain.posts.PostRepository;
import com.dewhy.webservice.dto.posts.PostMainResponseDto;
import com.dewhy.webservice.dto.posts.PostSaveRequestDto;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service
public class PostsService {
    private PostRepository postsRepository;

    @Transactional
    public Long save(PostSaveRequestDto dto){
        return postsRepository.save(dto.toEntity()).getId();
    }

    @Transactional(readOnly = true)
    public List<PostMainResponseDto> findAllDesc(){
        return postsRepository.findAllDesc()
                .map(PostMainResponseDto::new)
                .collect(Collectors.toList());
    }


}
