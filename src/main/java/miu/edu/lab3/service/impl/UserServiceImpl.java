package miu.edu.lab3.service.impl;

import lombok.RequiredArgsConstructor;

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

//    @Override
//    public Page<User> paging(PagingRequest pagingRequest) {
//        var direction = (pagingRequest.isAscending()) ? Sort.Direction.ASC : Sort.Direction.DESC;
//
//        var request = PageRequest
//                .of(pagingRequest.getPage(), pagingRequest.getPageSize(), direction,pagingRequest.getSortBy());
//        return userRepo.findAll(request);
//    }

    @Override
    public List<User> findAll() {
        return userRepo.findAll();
    }

    @Override
    public User findById(int id) {
        return userRepo.findById(id);
    }

//    @Override
//    public UserDto findByIdDto(int id) {
//        return modelMapper.map(userRepo.findById(id), UserDto.class);
//    }

    @Override
    public void deleteById(int id) {
        userRepo.deleteById(id);

    }
}
