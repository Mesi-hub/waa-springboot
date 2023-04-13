package miu.edu.lab6.entity.dto;

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