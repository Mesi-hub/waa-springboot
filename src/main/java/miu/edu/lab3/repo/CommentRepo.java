package miu.edu.lab3.repo;

import miu.edu.lab3.entity.Comment;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentRepo extends CrudRepository<Comment, Long> {
    List<Comment> findByPostId(Long postId);
    void deleteById(Long id);
}
