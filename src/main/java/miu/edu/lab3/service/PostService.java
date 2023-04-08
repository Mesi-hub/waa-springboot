package miu.edu.lab3.service;

import miu.edu.lab3.entity.Post;

import java.util.List;

public interface PostService {

    //public PostDto getByIdDto(int id);
    public List<Post> findAll();

    public Post findById(int id);
//
//    public Post getById(int id);
//
//    public void save(Post p);

   // public void update(int id, Post p);

   // public void deleteById(int id);

    Post getById(int id);

    void save(Post p);

    void delete(Long id);

    Post getById(Long id);

    // Post getById(Long id);
}
