package miu.edu.lab3.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import java.util.List;

@Entity
@Table(name = "users")
@Data
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    //@SequenceGenerator(name = "test", sequenceName = "user_id_seq")
    private long id;
    private String name;


    //@OneToMany(cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
    @OneToMany
    @JsonManagedReference
    @Fetch(FetchMode.SELECT)
    @JoinColumn(name = "user_id")
    private List<Post> posts;
}