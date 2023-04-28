package miu.edu.lab5.controller;


import lombok.RequiredArgsConstructor;
import miu.edu.lab6.aspect.annotation.ExecutionTime;
import miu.edu.lab6.aspect.annotation.LogInfo;
import miu.edu.lab6.entity.User;
import miu.edu.lab6.service.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/admin")
public class AdminController {

    private final UserService userService;


    @ExecutionTime
    @LogInfo
    @GetMapping
    public List<User> getUsers(){
        return userService.findAll();
    }


}