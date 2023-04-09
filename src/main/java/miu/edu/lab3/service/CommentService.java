package miu.edu.lab3.service;

import miu.edu.lab3.entity.Comment;

import java.util.List;

public interface CommentService {
    List<Comment> findAll();
    void save(Comment comment);
    void delete(Long id);
    Comment getById(Long id);
    void update(Long id, Comment comment);
    boolean deleteById(Long id);
    List<Comment> getCommentsByPostId(Long postId);
}
