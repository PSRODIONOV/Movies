package service;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ReviewRepository extends CrudRepository<Review, Long> {
    @Query(value = "Select r from Review r where r.author like :name")
    List<Review> getMyAllReview(@Param("name") String name);
}
