package miu.edu.lab2.entity.dto;

import lombok.*;
import miu.edu.lab2.entity.Post;

import java.util.List;
@NoArgsConstructor
@AllArgsConstructor

@Data
public class UserDto {
    long id;
    String name;
    List<Post> posts;

}