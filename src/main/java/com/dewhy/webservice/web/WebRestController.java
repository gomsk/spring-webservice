package com.dewhy.webservice.web;

import com.dewhy.webservice.dto.posts.PostSaveRequestDto;
import com.dewhy.webservice.service.PostsService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
@AllArgsConstructor
public class WebRestController {

    private PostsService postService;

    @GetMapping("/")
    public String main(Model model){
        model.addAttribute("posts", postService.findAllDesc());
        return "main";
    }

    @PostMapping("/posts")
    public void savePosts(@RequestBody PostSaveRequestDto dto){
        postService.save(dto);
    }
}
