package miu.edu.lab5.service;

import miu.edu.lab5.entity.Post;

import java.util.List;

public interface PostService {

    List<Post> findAll();

    Post getById(Long id);

    void save(Post post);

    void update(Long id, Post post);

    boolean deleteById(Long id);
}
