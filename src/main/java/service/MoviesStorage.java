package service;

import java.util.List;

public interface MoviesStorage {
    Movie getMovieById(String id);
    List<Movie> searchMovie(String key, String substr);
    boolean addReview(Review review);
    boolean updateReview(Review review);
    List<Review> getMyAllReview();
    boolean delReviewById(long id);
    List<Genre> getAllGenre();
    List<TitleType> getAllTitleType();
}
