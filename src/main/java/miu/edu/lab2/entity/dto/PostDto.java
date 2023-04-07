package miu.edu.lab2.entity.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import miu.edu.lab2.entity.Post;
import org.modelmapper.ModelMapper;

@NoArgsConstructor
//@AllArgsConstructor
@Getter
@Setter
public class PostDto {
    private long id;
    private String title;
    private String content;
    private String author;
    private int userId;

    public PostDto(Long id, String title, String content, String author) {
    }

    public static PostDto from(Post post) {
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(post, PostDto.class);
    }



}