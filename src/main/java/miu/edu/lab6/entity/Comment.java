package miu.edu.lab6.entity;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.stereotype.Component;


@Data
@Component
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "comments")
public class Comment {
    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    private long id;
    private String content;

    @ManyToOne
    private Post post;

}