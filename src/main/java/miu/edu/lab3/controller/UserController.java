package miu.edu.lab3.controller;

import lombok.RequiredArgsConstructor;
import miu.edu.lab3.entity.User;
import miu.edu.lab3.service.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/users")
public class UserController {

    private final UserService userService;

    @GetMapping
    public List<User> getUsers(){
        return userService.findAll();
    }
    @GetMapping("/{id}")
    public User getUsers(@PathVariable("id") int id){
        return userService.findById(id);
    }

    @DeleteMapping ("/{id}")
    public void deleteUser(@PathVariable("id") int id){
        userService.deleteById(id);
    }
    //TODO - implement @PostMapping for users
}
