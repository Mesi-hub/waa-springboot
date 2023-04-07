package miu.edu.lab2.repo.Impl;

import miu.edu.lab2.entity.Post;
import miu.edu.lab2.repo.PostRepo;
import org.springframework.stereotype.Repository;
import java.util.stream.Collectors;
import java.util.*;


@Repository
public class PostRepoImpl implements PostRepo {

    private final List<Post> database = new ArrayList<>();
    private Long nextId = 100L;

    @Override
    public <S extends Post> Iterable<S> saveAll(Iterable<S> entities) {
        return null;
    }

    @Override
    public Optional<Post> findById(Integer integer) {
        return Optional.empty();
    }

    @Override
    public boolean existsById(Integer integer) {
        return false;
    }

    @Override
    public List<Post> findAll() {
        return new ArrayList<>(database);
    }

    @Override
    public Iterable<Post> findAllById(Iterable<Integer> integers) {
        return null;
    }

    @Override
    public long count() {
        return 0;
    }

    @Override
    public void deleteById(Integer integer) {

    }

    @Override
    public void delete(Post entity) {

    }

    @Override
    public void deleteAllById(Iterable<? extends Integer> integers) {

    }

    @Override
    public void deleteAll(Iterable<? extends Post> entities) {

    }

    @Override
    public void deleteAll() {

    }

    @Override
    public Post findById(Long id) {
        return database.stream()
                .filter(post -> Objects.equals(post.getId(), id))
                .findFirst()
                .orElse(null);
    }

    @Override
    public Post save(Post post) {
        post.setId(nextId++);
        database.add(post);
        return post;
    }

    @Override
    public void deleteById(Long id) {
        database.removeIf(post -> Objects.equals(post.getId(), id));
    }

    @Override
    public void deleteById(int id) {

    }

    @Override
    public List<Post> findByAuthor(String author) {
        return database.stream()
                .filter(post -> Objects.equals(post.getAuthor(), author))
                .collect(Collectors.toList());
    }
}
