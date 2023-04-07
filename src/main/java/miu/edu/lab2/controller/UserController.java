package miu.edu.lab2.controller;

import miu.edu.lab2.entity.Post;
import miu.edu.lab2.entity.User;
import miu.edu.lab2.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/users")
public class UserController {

    private  UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @GetMapping("/{id}")
    public User getUserById(@PathVariable("id") Long id) {
        return userService.getUserById(id);
    }

    @PostMapping
    public User saveUser(@RequestBody User user) {
        return userService.saveUser(user);
    }

    @GetMapping("/{id}/posts")
    public List<Post> getUserPostsById(@PathVariable("id") Long id) {
        return userService.getUserPostsById(id);
    }
}