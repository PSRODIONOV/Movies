package service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.ejb.Singleton;
import java.util.*;

@Component
@Singleton
public class MoviesStorageImpl implements MoviesStorage{

    @Autowired
    private MovieAccessService mas;
    @Autowired
    private UserStorageImpl US;

    private List<Movie> foundMovieList = new ArrayList<>();

    @Override
    public List<Movie> searchMovie(String key, String substr){
        if((foundMovieList = mas.searchMovie(key, substr)) != null)
            return foundMovieList;
        return null;
    }

    @Override
    public Movie getMovieById(String id){
        return mas.getMovieById(id);
    }

    @Override
    public boolean addReview(Review review){
        if(!US.getCurrentUser().checkAdmin()) {
            review.setAuthor(US.getCurrentUser().getlogin());
            review.setDate_and_time(new java.sql.Date(Calendar.getInstance().getTime().getTime()));
            return mas.addReview(review);
        }
        return false;
    }

    @Override
    public boolean updateReview(Review review){
        if(US.getCurrentUser().checkAdmin())
            return  mas.updateReview(review);
        return false;
    }

    @Override
    public List<Review> getMyAllReview(){
        if(!US.getCurrentUser().checkAdmin())
            return mas.getMyAllReview(US.getCurrentUser());
        return null;
    }

    @Override
    public boolean delReviewById(long id){
        return  mas.delReviewById(id, US.getCurrentUser());
    }

    @Override
    public List<Genre> getAllGenre(){
        return mas.getAllGenre();
    }

    @Override
    public List<TitleType> getAllTitleType(){
        return mas.getAllTitleType();
    }

}