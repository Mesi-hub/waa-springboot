package miu.edu.lab6.entity.dto;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Data
public class PostDto {
    private long id;
    private String title;
    private String content;
    private String author;
    private int userId;
}
