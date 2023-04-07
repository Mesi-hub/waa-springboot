
package miu.edu.lab2.controllers;

import miu.edu.lab2.service.PostService;
import miu.edu.lab2.dto.PostDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/posts")
public class PostController {

    @Autowired
    private IPostService postsService;

    @GetMapping()
    public List<PostDto> findAllPosts() {
        return postsService.findAll();
    }

    @GetMapping(headers = {"api-version=v2"})
    public List<PostDto> findAllPostsV2() {
        return  postsService.findAllV2();
    }

    @GetMapping("/{id}")
    public PostDto findPostById(@PathVariable int id) {
        return postsService.findPostById(id);
    }

    @PostMapping
    public ResponseEntity<String> addPost(@RequestBody PostDto newPost) {
        if(postsService.addPost(newPost))
            return ResponseEntity.status(HttpStatus.CREATED)
                    .body("Added OK.");
        else
            return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED)
                    .body("Failed to add." );
    }

    @DeleteMapping("/{id}")
    public boolean deletePost(@PathVariable int id) {
        return postsService.deletePostById(id);
    }

    @PutMapping("/{id}")
    public boolean updatePost(@PathVariable int id, @RequestBody PostDto updatedPost) {
        updatedPost.setId(id);
        return postsService.updatePost(updatedPost);
    }

}
