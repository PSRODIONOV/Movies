package service;

import java.util.List;

public interface MovieAccessService {
    Movie getMovieById(String id);
    List<Movie> searchMovie(String key, String substr);
    boolean addReview(Review review);
    boolean updateReview(Review review);
    List<Review> getMyAllReview(User user);
    boolean delReviewById(long id, User user);
    List<Genre> getAllGenre();
    List<TitleType> getAllTitleType();
}
