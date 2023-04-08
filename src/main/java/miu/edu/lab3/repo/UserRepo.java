package miu.edu.lab3.repo;

import miu.edu.lab3.controller.UserController;
import miu.edu.lab3.entity.User;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepo extends PagingAndSortingRepository<UserController,Integer> {

    List<User> findAll();

    User findById(int id);

    void deleteById(int id);
}
