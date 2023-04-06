package miu.edu.lab2.service.impl;

import lombok.RequiredArgsConstructor;
import miu.edu.lab2.domain.Post;
import miu.edu.lab2.repo.PostRepo;
import miu.edu.lab2.service.PostService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PostServiceImpl implements PostService {
    private final PostRepo postRepo;

    @Override
    public List<Post> findAll() {
        return postRepo.findAll();
    }

    @Override
    public Post getById(int id) {
        return postRepo.getById(id);
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
    public void deleteById(int id) {
        postRepo.deleteById(id);
    }
}