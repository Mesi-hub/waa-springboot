package miu.edu.lab3.service.impl;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import lombok.RequiredArgsConstructor;
import miu.edu.lab3.entity.Post;
import miu.edu.lab3.repo.PostRepo;
import miu.edu.lab3.repo.UserRepo;
import miu.edu.lab3.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PostServiceImpl implements PostService {

    private final PostRepo postRepo;
    private final UserRepo userRepo;

    @PersistenceContext
    private EntityManager entityManager;

    @Autowired
    private org.modelmapper.ModelMapper modelMapper; // TODO - Implement DTOs

    @Override
    public List<Post> findAll() {
        return postRepo.findAll();
    }

    @Override
    public void save(Post post) {
        postRepo.save(post);
    }

    @Override
    public boolean deleteById(Long id) {
        if (postRepo.existsById(id)) {
            postRepo.deleteById(id);
            return true;
        }
        return false;
    }

    @Override
    public Post getById(Long id) {
        return postRepo.findById(id).orElse(null);
    }

    @Override
    public void update(Long id, Post post) {
        Post existingPost = postRepo.findById(id).orElse(null);
        if (existingPost != null) {
            existingPost.setTitle(post.getTitle());
            existingPost.setContent(post.getContent());
            postRepo.save(existingPost);
        }
    }
}
