package miu.edu.lab3.service;

import miu.edu.lab3.entity.Post;

import java.util.List;

public interface PostService {

    List<Post> findAll();

    Post getById(Long id);

    void save(Post post);

    void update(Long id, Post post);

    boolean deleteById(Long id);
}
