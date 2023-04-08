package miu.edu.lab3.service;

import miu.edu.lab3.entity.Comment;

import java.util.List;

public interface CommentService {
    Comment getCommentById(Long id);
    Comment createComment(Comment comment);
    Comment updateComment(Long id, Comment comment);
    boolean deleteComment(Long id);
    List<Comment> getCommentsByPostId(Long postId);
}
