package miu.edu.lab3.service;

import miu.edu.lab3.domain.Post;

import java.util.List;

public interface PostService {

    public List<Post> findAll();

    public Post getById(int id);

    public void save(Post p);

    public void update(int id, Post p);

    public void deleteById(int id);

}
