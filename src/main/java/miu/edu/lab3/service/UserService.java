package miu.edu.lab3.service;

import miu.edu.lab3.entity.User;

import java.util.List;

public interface UserService {

    List<User> findAll();
    void save(User user);
    User findById(int id);
    void deleteById(int id);
    //Comment findCommentById(int userId, int postId, int commentId);
}
