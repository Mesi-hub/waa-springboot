package miu.edu.lab5.repo;

import miu.edu.lab5.entity.Post;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostRepo extends CrudRepository<Post, Long> {

    public List<Post> findAll();
    public  List<Post> findPostsByTitleIgnoreCase(String title);

}
