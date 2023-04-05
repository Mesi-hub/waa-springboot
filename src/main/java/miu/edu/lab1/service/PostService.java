package miu.edu.lab1.service;

import miu.edu.lab1.domain.Post;

import java.util.List;

public interface PostService {

    public Post findById();

    public List<Post> findAll();

    public Post getById(int id);

    public void save(Post p);

    public void update(int id, Post p);

    public void delete(int id);
}
