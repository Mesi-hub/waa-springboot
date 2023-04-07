package miu.edu.lab3.domain;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

//@AllArgsConstructor
@NoArgsConstructor
@Data
@Component
public class Post {
    private Long id;
    String title;
    String content;
    String author;

    public Post(Long id, String title, String content, String author) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.author = author;
    }
}
