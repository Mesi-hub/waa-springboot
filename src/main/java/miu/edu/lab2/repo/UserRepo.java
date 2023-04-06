package miu.edu.lab2.repo;

import miu.edu.lab2.domain.Post;
import miu.edu.lab2.domain.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepo extends CrudRepository<User,Integer > {


}
