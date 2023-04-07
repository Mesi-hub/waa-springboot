package miu.edu.lab2.service;

import miu.edu.lab2.entity.Post;
import miu.edu.lab2.entity.dto.PostDto;

import java.util.List;

public interface PostService {

    public List<PostDto> findAll();

    Post findById(int id);

    public void save(PostDto p);

    public void deleteById(int id);

    public void updatePost(int id, Post p);
    List<Post> filterByAuthor(String author);
    public PostDto findPostById(int id);
    public void deletePostById();


    List<Post> getAllPosts();

    Post getPostById(Long id);

    Post savePost(Post post);
}
