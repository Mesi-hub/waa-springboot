package miu.edu.lab1.repo;

import miu.edu.lab1.domain.Post;

import java.util.List;

public interface PostRepo {

    //public Post findById();

    public List<Post> findAll();

    public Post getById(int id);

    public void save(Post p);

    public void update(int id, Post p);

    public void deleteById(int id);


}
