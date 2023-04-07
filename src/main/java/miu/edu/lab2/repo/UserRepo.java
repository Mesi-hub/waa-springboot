package miu.edu.lab2.repo;

import miu.edu.lab2.entity.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo extends CrudRepository<User,Long> {

//    @Query(value = "SELECT * FROM users u WHERE u.id IN (SELECT p.user_id FROM posts p GROUP BY p.user_id HAVING count(*) > :count)", nativeQuery = true)
//    List<User> findUsersWithPosts(int count);

}
