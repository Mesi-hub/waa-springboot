package miu.edu.lab3.service.impl;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import lombok.RequiredArgsConstructor;
import miu.edu.lab3.entity.Post;
import miu.edu.lab3.repo.PostRepo;
import miu.edu.lab3.repo.UserRepo;
import miu.edu.lab3.service.PostService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.util.Streamable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PostServiceImpl implements PostService {

    @Autowired
    PostRepo postRepo;

    @Autowired
    UserRepo userRepo;

    @PersistenceContext
    EntityManager entityManager;


    @Autowired
    ModelMapper modelMapper; // TODO - Implement DTOs so that the model mapper come on action.


//    //To be used later once the ListMapper method is implemented
//    @Override
//    ListMapper listMapper;
//
//    @Override
//    public List<PostDto> findAll(){
//        return listMapper.mapList(postRepo.findAll(), new PostDto);
//    }

    @Override
    public List<Post> findAll() {
        Iterable<Post> iterable = postRepo.findAll();
        List<Post> list = Streamable.of(iterable).toList();
        return list;
    }

    @Override
    public Post findById(int id) {
        return null;
    }

    @Override
    public Post getById(int id) {
        return null;
    }

    @Override
    public void save(Post p) {

    }

    @Override
    public void delete(Long id) {
        postRepo.deleteById(id);
    }

    @Override
    public Post getById(Long id) {
        return postRepo.findById(id).get();
    }
}

//TODO - Implement remaining methods
//TODO - Database configuration