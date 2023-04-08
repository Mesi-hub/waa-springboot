package miu.edu.lab3.service;

import miu.edu.lab3.entity.User;

import java.util.List;

public interface UserService {
    //Page<User> paging(PagingRequest pagingRequest);
    //UserDto findByIdDto(int id);


    List<User> findAll();

    User findById(int id);
    void deleteById(int id);
}
