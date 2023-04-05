package miu.edu.lab1.service.impl;

import miu.edu.lab1.domain.Post;
import miu.edu.lab1.repo.PostRepo;
import miu.edu.lab1.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostServiceImpl implements PostService {

    @Autowired
    PostRepo postRepo;

    @Override
    public Post findById() {
        return postRepo.findById();
    }

    @Override
    public List<Post> findAll() {
        return postRepo.findAll();
    }

    @Override
    public Post getById(int id) {
        return postRepo.findById();
    }

    @Override
    public void save(Post p) {
    postRepo.save(p);
    }

    @Override
    public void update(int id, Post p) {
        postRepo.update(id, p);
    }

    @Override
    public void delete(int id) {
        postRepo.delete(id);
    }
}
