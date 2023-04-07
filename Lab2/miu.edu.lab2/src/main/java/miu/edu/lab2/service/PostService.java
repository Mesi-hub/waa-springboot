package miu.edu.lab2.service;

import miu.edu.lab2.dto.PostDto;
import miu.edu.lab2.dto.UserDto;

import java.util.List;

public interface PostService {
    public List<PostDto> findAll();
    List<PostDto> findAllV2();
    public PostDto findPostById(int id);
    public boolean deletePostById(int id);
    public boolean addPost(PostDto postDto);

    boolean updatePost(PostDto postDto);


}
