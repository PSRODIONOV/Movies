package service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Service
@Component
public class MovieAccessServiceImpl implements MovieAccessService {

    @PersistenceContext
    public EntityManager em;
    @Autowired
    private ReviewRepository rr;
    @Autowired
    private GenreRepository gr;
    @Autowired
    private titleTypeRepository ttr;

    public MovieAccessServiceImpl(){
    }
    @Override
    public List<Genre> getAllGenre(){
        List<Genre> genres;
        genres = (List<Genre>)gr.findAll();
        return genres;
    }
    @Override
    public List<TitleType> getAllTitleType(){
        List<TitleType> titleTypes = (List<TitleType>)ttr.findAll();
        return titleTypes;
    }

    @Override
    public Movie getMovieById(String movie_id){
        Movie m = em.find(Movie.class, movie_id);
        m.setReviewList((List<Review>)rr.findAll());
        return m;
    }

    @Override
    public List<Movie> searchMovie(String key, String substr){
        List<Movie> foundMovieList = new ArrayList<>();
        TypedQuery<Movie> q;
            switch(key) {
                case "originTitle":
                    q = em.createQuery("select m from Movie m where m.originTitle = :key", Movie.class);
                    q.setParameter("key", substr);
                    break;
                case "fromRating":
                    q = em.createQuery("select m from Movie m where m.rating >= :key", Movie.class);
                    q.setParameter("key", Integer.parseInt(substr));
                break;
                case "toRating":
                    q = em.createQuery("select m from Movie m where m.rating <= :key", Movie.class);
                    q.setParameter("key", Float.parseFloat(substr));
                break;
                case "fromYear":
                    q = em.createQuery("select m from Movie m where  m.startYear >= :key", Movie.class);
                    q.setParameter("key", Integer.parseInt(substr));
                break;
                case "toYear":
                    q = em.createQuery("select m from Movie m where m.startYear <= :key", Movie.class);
                   q.setParameter("key", Integer.parseInt(substr));
                break;

                case "isAdult":
                    q = em.createQuery("select m from Movie m where m.isAdult = :key", Movie.class);
                    q.setParameter("key", Integer.parseInt(substr));
                break;
                default:
                    q = null;
            }
            foundMovieList = q.getResultList();
            return foundMovieList;
    }
    @Override
    @Transactional
    public boolean addReview(Review review){
        rr.save(review);
        return true;
    }

    @Override
    @Transactional
    public boolean updateReview(Review review){
        em.merge(review);
        em.flush();
        return false;
    }

    @Override
    public List<Review> getMyAllReview(User user){
        List<Review> myReviews = rr.getMyAllReview(user.getlogin());
        return myReviews;
    }

    @Override
    @Transactional
    public boolean delReviewById(long id, User user){
        Review r;
        if(user.checkAdmin()) {
            r = rr.findOne(id);
        }
        else{
            r = rr.findMyReviewById(user.getlogin(), id);
        }
        if(r == null)
            return false;
        rr.delete(r);
        em.flush();
        return true;
    }

}
