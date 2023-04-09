package miu.edu.lab3.service.impl;

import lombok.RequiredArgsConstructor;
import miu.edu.lab3.controller.UserController;
import miu.edu.lab3.entity.User;
import miu.edu.lab3.repo.UserRepo;
import miu.edu.lab3.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    @Autowired
    ModelMapper modelMapper;

    private final UserRepo userRepo;

    @Override
    public List<User> findAll() {
        return userRepo.findAll();
    }

    @Override
    public User findById(int id) {
        return userRepo.findById(id);
    }

    @Override
    public void deleteById(int id) {
        userRepo.deleteById(id);

    }
}

//TODO - fix bugs CommentServiceImpl