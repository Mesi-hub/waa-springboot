package miu.edu.lab2.service.impl;

import jakarta.persistence.EntityNotFoundException;
import lombok.*;
import miu.edu.lab2.entity.Post;
import miu.edu.lab2.entity.dto.PostDto;
import miu.edu.lab2.repo.PostRepo;
import miu.edu.lab2.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@NoArgsConstructor
@AllArgsConstructor
@Service


public class PostServiceImpl implements PostService {

    private PostRepo postRepo;

    @Autowired
    public void PostService(PostRepo postRepo) {
        this.postRepo = postRepo;
    }

    public List<Post> getAllPosts() {
        return postRepo.findAll();
    }

    public Post getPostById(Long id) {
        return postRepo.findById(id);
    }

    public Post savePost(Post post) {
        return postRepo.save(post);
    }

    public void deletePostById(Long id) {
        postRepo.deleteById(id);
    }

    public Post updatePost(Long id, Post updatedPost) {
        Post post = postRepo.findById(id);
        if (post == null) {
            throw new EntityNotFoundException("Post not found with id: " + id);
        }
        post.setTitle(updatedPost.getTitle());
        post.setContent(updatedPost.getContent());
        post.setAuthor(updatedPost.getAuthor());
        return postRepo.save(post);
    }

    @Override
    public List<PostDto> findAll() {
        return null;
    }

    @Override
    public Post findById(int id) {
        return null;
    }

    @Override
    public void save(PostDto p) {

    }

    @Override
    public void deleteById(int id) {

    }

    @Override
    public void updatePost(int id, Post p) {

    }

    @Override
    public List<Post> filterByAuthor(String author) {
        return null;
    }

    @Override
    public PostDto findPostById(int id) {
        return null;
    }

    @Override
    public void deletePostById() {

    }
}
