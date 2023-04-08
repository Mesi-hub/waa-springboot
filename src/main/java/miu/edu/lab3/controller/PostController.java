package miu.edu.lab3.controller;

import miu.edu.lab3.entity.Post;
import miu.edu.lab3.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/posts")
//@RequestMapping
public class PostController {

    @Autowired
    PostService postService;

//    @GetMapping
//    public Post findById(int id){
//        return new Post(200L,"RestAPI","Fake Data Demo","Meseret");
//    }


//    @GetMapping("/find")
//    public String findText(){
//        return "Hello";
//    }
//    //TODO - implement findById method. It returns only portion of data => Payload.
//    @GetMapping("/dto/{id}")
//    public PostDto getByIdDto(@PathVariable("id") int id){
//        return postService.getByIdDto(id);
//    }

    @GetMapping
    public List<Post> findAll(){
        return postService.findAll();
    }



    @GetMapping("/{id}")
    public ResponseEntity<Post> getById(@PathVariable int id) {
        var post = postService.getById(id);
        return ResponseEntity.ok(post);
    }


//        @DeleteMapping("/{id}")
//        public ResponseEntity<String> deleteById(@PathVariable int id) {
//            postService.deleteById(id);
//            return ResponseEntity.ok("OK deleted");
//        }

//        //Recommended way
//        @ResponseStatus(HttpStatus.NO_CONTENT)
//        @DeleteMapping("/{id}")
//        public void deleteById(@PathVariable int id) {
//            postService.deleteById(id);
//        }

        @ResponseStatus(HttpStatus.CREATED)
        @PostMapping
        public void save(@RequestBody Post post){
            postService.save(post);
        }

//        @PutMapping("/{id}")
//        public void update(@RequestBody Post post, @PathVariable int id){
//            postService.update(id,post);
//        }
    }
