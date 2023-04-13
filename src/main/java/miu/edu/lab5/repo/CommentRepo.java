package miu.edu.lab5.repo;

import miu.edu.lab5.entity.Comment;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CommentRepo extends CrudRepository<Comment, Long> {
    List<Comment> findByPostId(Long postId);
    void deleteById(Long id);
    List<Comment> findAll();
    Comment save(Comment comment);
    Optional<Comment> findById(Long id);
   // void update(Long id, Comment comment);
    List<Comment> getCommentsByPostId(Long postId);
}
