package miu.edu.lab5.service;

import miu.edu.lab5.entity.User;
import miu.edu.lab5.entity.dto.UserDto;

import java.util.List;

public interface UserService {

    List<User> findAll();
    void save(UserDto userDto);
    User findById(int id);
    void deleteById(int id);
    //Comment findCommentById(int userId, int postId, int commentId);
}
