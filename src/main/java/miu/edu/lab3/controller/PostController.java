package miu.edu.lab3.controller;

import miu.edu.lab3.domain.Post;
import miu.edu.lab3.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("posts")
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

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteById(@PathVariable int id) {
        postService.deleteById(id);
        return ResponseEntity.ok("OK deleted");
    }

    @PutMapping("/{id}")
    public void update(@RequestBody Post post, @PathVariable int id){
        postService.update(id,post);
    }
}
