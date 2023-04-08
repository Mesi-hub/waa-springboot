package miu.edu.lab3.repo;

import miu.edu.lab3.entity.Post;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostRepo extends CrudRepository<Post, Long> {

    //public List<Post> findByPriceGreaterThan(float price);

//    @Query(value = "SELECT * FROM POST WHERE AUTHOR = :author", nativeQuery = true)
//    public List<Post> findByAuthor(@Param("author") String author);

/*
    @Query( "select p from Post p where count(p.reviews) >= :num" )
    public List<Post> findProductWithReviews(int num); // 10

 */

    public List<Post> findPostByTitle(String title);


}
