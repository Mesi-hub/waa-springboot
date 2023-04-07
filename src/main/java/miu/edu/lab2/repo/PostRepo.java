package miu.edu.lab2.repo;

import miu.edu.lab2.entity.Post;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface PostRepo extends CrudRepository<Post, Integer> {

    List<Post> findAll();
    Post findById(Long id);
    Post save(Post post);
    void deleteById(Long id);
    void deleteById(int id);
    List<Post> findByAuthor(String author);




}
