package miu.edu.lab1.repo;

import miu.edu.lab1.domain.Post;
import miu.edu.lab1.domain.Product;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class PostRepoImpl implements PostRepo {

    private static List<Post> posts;
    private static Long postId = 100L;
    static{
        posts = new ArrayList<>();
        Post p1 = new Post(101L, "Lab 1 Demo", "RESTful", "Mesi");
        Post p2 = new Post(200L, "Lab 1 Demo", "RESTful", "Abebe");
        posts.add(p1);
        posts.add(p2);
    }

    public List<Post> findAll(){
        return posts;
    }

    public void save(Post p){
        p.setId(postId);
        postId++;
        posts.add(p);
    }

    @Override
    public void update(int id, Post p) {

    }

    @Override
    public void delete(int id) {

    }

    public Post getById(int id){
        return posts
                .stream()
                .filter(l ->l.getId()==id)
                .findFirst()
                .orElse(null);
    }



    @Override
    public Post findById() {
        return new Post(1L, "Spring Demo","MVC", "Meseret");
    }



}
