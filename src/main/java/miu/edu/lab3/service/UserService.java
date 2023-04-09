package miu.edu.lab3.service;

import miu.edu.lab3.entity.User;

import java.util.List;

public interface UserService {

    List<User> findAll();

    User findById(int id);
    void deleteById(int id);
}
