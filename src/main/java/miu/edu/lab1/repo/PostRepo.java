package miu.edu.lab1.repo;

import miu.edu.lab1.domain.Post;
import miu.edu.lab1.domain.Product;

import java.util.List;

public interface PostRepo {

    public Post findById();

    public List<Post> findAll();

    public Post getById(int id);

    public void save(Post p);

    public void update(int id, Post p);

    public void delete(int id);


}
