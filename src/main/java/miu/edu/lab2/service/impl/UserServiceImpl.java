package miu.edu.lab2.service.impl;

import jakarta.persistence.EntityNotFoundException;
import miu.edu.lab2.entity.Post;
import miu.edu.lab2.entity.User;
import miu.edu.lab2.entity.dto.UserDto;
import miu.edu.lab2.repo.UserRepo;
import miu.edu.lab2.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class UserServiceImpl implements UserService {

    private UserRepo userRepo;

    @Autowired
    public void UserService(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    public List<User> getAllUsers() {
        return (List<User>) userRepo.findAll();
    }

//    @Override
//    public User saveUser(User userDto) {
//
//        return userDto;
//    }

    @Override
    public List<UserDto> findAll() {
        return null;
    }

    public User getUserById(Long id) {
        Optional<User> user = userRepo.findById(id);
        if (!user.isPresent()) {
            throw new EntityNotFoundException("User not found with id: " + id);
        }
        return user.get();
    }

    public User saveUser(User user) {
        return userRepo.save(user);
    }

    public List<Post> getUserPostsById(Long id) {
        User user = getUserById(id);
        return user.getPosts();
    }
}
