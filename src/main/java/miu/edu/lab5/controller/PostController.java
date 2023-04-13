package miu.edu.lab5.controller;

import miu.edu.lab5.aspect.annotation.ExecutionTime;
import miu.edu.lab5.aspect.annotation.LogInfo;
import miu.edu.lab5.entity.Post;
import miu.edu.lab5.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/posts")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class PostController {

    @Autowired
    PostService postService;

    @ExecutionTime
    @LogInfo
    //@PreAuthorize("hasRole('ROLE_ADMIN')")
    @GetMapping
    public List<Post> findAll() {
        return postService.findAll();
    }
    @LogInfo
    @GetMapping("/{id}")
    public ResponseEntity<Post> getById(@PathVariable Long id) {
        Post post = postService.getById(id);
        if (post == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(post);
    }
    @LogInfo
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public void save(@RequestBody Post post) {
        postService.save(post);
    }
    @LogInfo
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PutMapping("/{id}")
    public void update(@PathVariable Long id, @RequestBody Post post) {
        postService.update(id, post);
    }
    @LogInfo
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteById(@PathVariable Long id) {
        boolean deleted = postService.deleteById(id);
        if (deleted) {
            return ResponseEntity.ok("Post deleted");
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}
