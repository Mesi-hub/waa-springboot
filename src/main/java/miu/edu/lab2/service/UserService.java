package miu.edu.lab2.service;

import miu.edu.lab2.entity.Post;
import miu.edu.lab2.entity.User;
import miu.edu.lab2.entity.dto.UserDto;

import java.util.List;

public interface UserService {
    List<UserDto> findAll();
    User getUserById(Long id);
    List<User> getAllUsers();
    User saveUser(User userDto);
    List<Post> getUserPostsById(Long id);
}
