package miu.edu.lab2.helper;

import miu.edu.lab2.entity.Post;
import miu.edu.lab2.entity.PostV2;
import miu.edu.lab2.entity.dto.PostDto;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PostMapper {

    private final ModelMapper modelMapper;

    @Autowired
    public PostMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    public PostDto toPostDto(Post post) {
        return modelMapper.map(post, PostDto.class);
    }

    public PostV2 toPostV2Dto(PostV2 post) {
        return modelMapper.map(post, PostV2.class);
    }

    public Post toPostEntity(PostDto postDto) {
        return modelMapper.map(postDto, Post.class);
    }

    public PostV2 toPostV2Entity(PostV2 postDto) {
        return modelMapper.map(postDto, PostV2.class);
    }

    public void updatePostEntity(PostDto postDto, Post post) {
        modelMapper.map(postDto, post);
    }

    public void updatePostV2Entity(PostV2 postDto, PostV2 post) {
        modelMapper.map(postDto, post);
    }

}