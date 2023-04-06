package miu.edu.lab1.controller;

import miu.edu.lab1.domain.Post;
import miu.edu.lab1.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("posts")  //api/v1/posts
public class PostController {

    @Autowired
    PostService postService;

    @GetMapping
    public List<Post> findAll(){
        return postService.findAll();
    }

    @PostMapping
    public void save(@RequestBody Post post){
        postService.save(post);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Post> getById(@PathVariable int id) {
        var post = postService.getById(id);
        return ResponseEntity.ok(post);
    }

}
