package service;

import java.util.List;

public interface MovieAccessService {
    public Movie getMovieById(String id);
    public List<Movie> searchMovie(String key, String substr);
    public boolean addReview(Review review);
    public boolean updateReview(Review review);
    public List<Review> getMyAllReview(User user);
    public boolean delReviewById(long id);
    public List<Genre> getAllGenre();
    public List<TitleType> getAllTitleType();
}
