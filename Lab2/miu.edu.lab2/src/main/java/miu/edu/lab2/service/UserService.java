package miu.edu.lab2.service;

import miu.edu.lab2.dto.PostDto;
import miu.edu.lab2.dto.UserDto;
import miu.edu.lab2.entity.Post;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

public interface UserService {
    List<UserDto> findAll();

    UserDto findById(int id);

    List<PostDto> findPostsById(int id);

    void save(UserDto userDto);

    void deleteById(int id);

    public List<UserDto> findUsersByPostsCountGreaterThan(int count);

}
