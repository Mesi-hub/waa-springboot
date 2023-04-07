package miu.edu.lab2.service;

import miu.edu.lab2.dto.PostDto;
import miu.edu.lab2.dto.UserDto;
import miu.edu.lab2.entity.User;
import miu.edu.lab2.repository.IUserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class UserServiceImpl implements  IUserService{
    @Autowired
    private UserRepo userRepo;
    private ModelMapper modelMapper = new ModelMapper();
    @Override
    public List<UserDto> findAll() {

        var users = userRepo.findAll();

        var usersDto = new ArrayList<UserDto>();

        users.forEach(u -> usersDto.add(modelMapper.map(u, UserDto.class)));

        return usersDto;
    }

    @Override
   public UserDto findById(int id) {
        var user = userRepo.findById(id);
        return modelMapper.map(user, UserDto.class);
   }

   @Override
   public List<PostDto> findPostsById(int id) {
        var posts =  userRepo
                .findById(id)
                .get()
                .getPosts();

        return  posts.stream()
                .map(p -> modelMapper.map(p, PostDto.class))
                .toList();
    }

    @Override
    public void save(UserDto userDto) {
        var newUser = modelMapper.map(userDto, User.class);
        userRepo.save(newUser);
    }

    @Override
    public void deleteById(int id) {
        userRepo.deleteById(id);
    }

   public List<UserDto> findUsersByPostsCountGreaterThan(int count) {
        var users = userRepo.findUsersWithPosts(count);
        if(users != null) {
            return users.stream()
                    .map(u -> modelMapper.map(u, UserDto.class))
                    .toList();
        }
        else {
            return new ArrayList<UserDto>();
        }
    }
}
