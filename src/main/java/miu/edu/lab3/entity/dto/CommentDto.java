package miu.edu.lab3.entity.dto;

import lombok.*;


@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Data
public class CommentDto {
    int id;
    int postId;
    String content;
}