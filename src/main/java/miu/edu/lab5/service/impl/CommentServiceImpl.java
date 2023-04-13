package miu.edu.lab5.service.impl;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import miu.edu.lab5.entity.Comment;
import miu.edu.lab5.repo.CommentRepo;
import miu.edu.lab5.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentServiceImpl implements CommentService {

    @Autowired
    private  CommentRepo commentRepo;

    @PersistenceContext
    private EntityManager entityManager;

    @Autowired
    private org.modelmapper.ModelMapper modelMapper; // TODO - Implement DTOs

    @Override
    public List<Comment> findAll() {
        return (List<Comment>) commentRepo.findAll();
    }

    @Override
    public void save(Comment comment) {
        commentRepo.save(comment);
    }

    @Override
    public boolean deleteById(Long id) {
        if (commentRepo.existsById(id)) {
            commentRepo.deleteById(id);
            return true;
        }
        return false;
    }

    @Override
    public Comment getById(Long id) {
        return commentRepo.findById(id).orElse(null);
    }

    @Override
    public void update(Long id, Comment comment) {
        Comment existingComment = commentRepo.findById(id).orElse(null);
        if (existingComment != null) {
            existingComment.setContent(comment.getContent());
            commentRepo.save(existingComment);
        }
    }

    @Override
    public List<Comment> getCommentsByPostId(Long postId) {
        return commentRepo.findByPostId(postId);
    }
}
