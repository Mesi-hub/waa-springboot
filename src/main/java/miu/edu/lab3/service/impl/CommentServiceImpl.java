package miu.edu.lab3.service.impl;

import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import miu.edu.lab3.entity.Comment;
import miu.edu.lab3.entity.Post;
import miu.edu.lab3.repo.CommentRepo;
import miu.edu.lab3.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@NoArgsConstructor
public class CommentServiceImpl implements CommentService {

    @Autowired
    CommentRepo commentRepo;


    @Override
    public Comment getCommentById(Long id) {
        return commentRepo.findById(id).orElse(null);
    }

    @Override
    public Comment createComment(Comment comment) {
        // Set the Post for the Comment
        Post post = comment.getPost();
        if (post != null) {
            comment.setPost(post);
        }
        return commentRepo.save(comment);
    }

    @Override
    public Comment updateComment(Long id, Comment comment) {
        Comment existingComment = commentRepo.findById(id).orElse(null);
        if (existingComment != null) {
            comment.setId(id);
            return commentRepo.save(comment);
        } else {
            return null;
        }
    }

    @Override
    public boolean deleteComment(Long id) {
        Comment existingComment = commentRepo.findById(id).orElse(null);
        if (existingComment != null) {
            commentRepo.deleteById(id);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public List<Comment> getCommentsByPostId(Long postId) {
        return commentRepo.findById(postId);
    }
}