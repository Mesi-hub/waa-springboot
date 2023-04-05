package miu.edu.lab2.repo;

import miu.edu.lab2.entity.Post;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface PostRepo extends CrudRepository<Post, Integer> {
    public List<Post> findAll();
}