package miu.edu.lab2.service;

import miu.edu.lab2.dto.PostDto;
import miu.edu.lab2.repo.PostRepo;
import miu.edu.lab2.entity.Post;
import miu.edu.lab2.repo.UserRepo;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class PostServiceImpl implements IPostService {
    @Autowired
    private PostRepo postRepo;
    @Autowired
    private UserRepo userRepo;

    private ModelMapper modelMapper = new ModelMapper();

    @Override
    public List<PostDto> findAll() {
        var posts = postRepo.findAll();
        return posts.stream()
                .map(p -> modelMapper.map(p, PostDto.class))
                .collect(Collectors.toList());
    }

    public List<PostDto> findAllV2() {
        var posts = postRepo.findAll();
        return posts.stream()
                .map(p -> modelMapper.map(p, PostDto.class))
                .map(p -> new PostDto(p.getId(), p.getTitle() + " v2", p.getContent(), p.getAuthor(), p.getUserId()))
                .collect(Collectors.toList());
    }

    @Override
    public PostDto findPostById(int id) {
        return modelMapper.map( postsRepo.findById(id), PostDto.class);
    }

    @Override
    public boolean deletePostById(int id) {
         postRepo.deleteById(id);
         return true;
    }

    @Override
    public boolean addPost(PostDto postDto) {
        var newPost = modelMapper.map(postDto, Post.class);
        var user = userRepo.findById(postDto.getUserId()).get();

        newPost.setUser(user);
        newPost.setCreatedDate(new Date());

         postRepo.save(newPost);

         return true;
    }

    @Override
   public boolean updatePost(PostDto postDto) {
        var post = modelMapper.map(postDto, Post.class);
         postRepo.save(post);
         return true;
    }
}
