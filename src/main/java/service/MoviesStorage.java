package service;

import java.util.List;

public interface MoviesStorage {
    public Movie getMovieById(String id);
    public List<Movie> searchMovie(String key, String substr);
    public void addReview(Review review);
    public boolean updateReview(Review review);
    public List<Review> getMyAllReview();
    public void delReviewById(long id);
    public List<Genre> getAllGenre();
    public List<TitleType> getAllTitleType();
}
