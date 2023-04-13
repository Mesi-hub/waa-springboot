package miu.edu.lab5.service;

import miu.edu.lab5.entity.Comment;

import java.util.List;

public interface CommentService {
    List<Comment> findAll();
    void save(Comment comment);
    void update(Long id, Comment comment);
    Comment getById(Long id);
    boolean deleteById(Long id);
    List<Comment> getCommentsByPostId(Long postId);

}
