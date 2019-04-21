package service;

import org.hibernate.annotations.GeneratorType;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "REVIEW")
public class Review {
    @Column(name = "movie_id")
    private String movie_id;
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "cust")
    @SequenceGenerator(name = "cust", sequenceName = "seq_cust", allocationSize = 1, initialValue = 1)
    private long review_id;
    @Column(name = "author")
    private String author;
    @Column(name = "text")
    private String text;
    @Column(name = "rating")
    private float rating;
    @Column(name = "date_and_time")
    private Date date_and_time;

    Review(){};

    public String getMovie_id(){
        return movie_id;
    }
    public long getReview_id(){
        return review_id;
    }
    public String getAuthor(){
        return author;
    }
    public String getText(){
        return text;
    }
    public float getRating(){
        return rating;
    }
    public Date getDate_and_time(){
        return date_and_time;
    }

    public void setMovie_id(String movie_id) {
        this.movie_id = movie_id;
    }

    public void setReview_id(long review_id) {
        this.review_id = review_id;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setText(String text) {
        this.text = text;
    }

    public void setRating(float rating) {
        this.rating = rating;
    }

    public void setDate_and_time(Date date_and_time) {
        this.date_and_time = date_and_time;
    }
}
