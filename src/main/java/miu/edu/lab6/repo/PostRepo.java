package miu.edu.lab6.repo;

import miu.edu.lab6.entity.Post;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostRepo extends CrudRepository<Post, Long> {

    public List<Post> findAll();
    public  List<Post> findPostsByTitleIgnoreCase(String title);

}
