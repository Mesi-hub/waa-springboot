package miu.edu.lab5.controller;

import lombok.RequiredArgsConstructor;
import miu.edu.lab5.aspect.annotation.*;
import miu.edu.lab5.entity.User;
import miu.edu.lab5.entity.dto.UserDto;
import miu.edu.lab5.service.UserService;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/users")
public class UserController {

    private final UserService userService;


    @ExecutionTime
    @LogInfo
    @GetMapping
    public List<User> getUsers(){
        return userService.findAll();
    }

    @ExecutionTime
    @LogInfo
    @GetMapping("/{id}")
    public User getUsers(@PathVariable("id") int id){
        return userService.findById(id);
    }

    @LogInfo
    @DeleteMapping ("/{id}")
    public void deleteUser(@PathVariable("id") int id){
        userService.deleteById(id);
    }

//    @GetMapping("/{userId}/posts/{postId}/comments/{commentId}")
//    public User findCommentById(@PathVariable int userId,
//                                      @PathVariable int postId,
//                                      @PathVariable int commentId) {
//
//        return userService.findCommentById(userId, postId, commentId);
//    }

    //TODO - implement @PostMapping for users

    @LogInfo
    @PostMapping()
    public ResponseEntity<String> save(@RequestBody UserDto newUser) {
        userService.save(newUser);
        return  ResponseEntity.status(HttpStatus.CREATED).body("Added successfully.");
    }
}
