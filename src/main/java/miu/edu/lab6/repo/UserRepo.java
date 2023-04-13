package miu.edu.lab6.repo;

import miu.edu.lab6.entity.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepo extends CrudRepository<User,Integer> {

//    @Query(value = "SELECT * FROM users u WHERE u.id IN (SELECT p.user_id FROM posts p GROUP BY p.user_id HAVING count(*) > :count)", nativeQuery = true)
//    List<User> findUsersWithPosts(int count);
//
//    List<User> getById(int id);
    List<User> findAll();
    User findByEmail(String email);
}
