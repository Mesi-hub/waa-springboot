package miu.edu.lab1.controller;

import miu.edu.lab1.domain.Post;
import miu.edu.lab1.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/posts")  //api/v1/posts
public class PostController {

    @Autowired
    PostService postService;

    @GetMapping
    public List<Post> findAll(){
        return postService.findAll();
    }
    @PostMapping
    public void save(@RequestBody Post post){
       // return; postService.save(post);
    }
}
