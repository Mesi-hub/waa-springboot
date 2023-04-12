package miu.edu.lab5.service.impl;

import miu.edu.lab5.entity.User;
import miu.edu.lab5.entity.dto.UserDto;
import miu.edu.lab5.repo.UserRepo;
import miu.edu.lab5.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private ModelMapper modelMapper;

    private final UserRepo userRepo;

    public UserServiceImpl(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    @Override
    public void save(UserDto userDto) {
        var newUser = modelMapper.map(userDto, User.class);
        userRepo.save(newUser);
    }
    @Override
    public List<User> findAll() {
        return (List<User>) userRepo.findAll();
    }

    @Override
    public User findById(int id) {
        return userRepo.findById(id).orElse(null);
    }

    @Override
    public void deleteById(int id) {
        userRepo.deleteById(id);
    }

//    @Override
//    public Comment findCommentById(int userId, int postId, int commentId) {
//        var user = userRepo
//                .findById(userId)
//                .get();
//
//        var post = user
//                .getPosts()
//                .stream()
//                .filter(p -> p.getId() == postId)
//                .findFirst()
//                .get();
//
//        var comm  = post
//                .getComments()
//                .stream()
//                .filter(c -> c.getId() == commentId)
//                .findFirst()
//                .get();
//
//        return modelMapper.map(comm, Comment.class);
//    }
}
