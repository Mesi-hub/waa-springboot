package miu.edu.lab3.repo;

import miu.edu.lab3.entity.Comment;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommentRepo extends CrudRepository <Comment, Integer>{
}
