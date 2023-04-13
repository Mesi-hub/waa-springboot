package miu.edu.lab6.service;

import miu.edu.lab6.entity.Comment;

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
