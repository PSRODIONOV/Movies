package service;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ReviewRepository extends CrudRepository<Review, Long> {
    @Query(value = "Select r from Review r where r.author like :name")
    List<Review> getMyAllReview(@Param("name") String name);

    @Query(value = "Select r from Review r where r.author like :name and r.review_id = :id")
    Review findMyReviewById(@Param("name") String name, @Param("id") long id);

    @Modifying
    @Query("update Review r set r.text=:text where r.review_id=:id")
    int updateReview(@Param("text") String text, @Param("id") long id);
}
