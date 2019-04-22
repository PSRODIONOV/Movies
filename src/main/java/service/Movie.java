package service;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "movie")
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "cust")
    @SequenceGenerator(name = "cust", sequenceName = "seq_cust")
    private String movie_id;
    @OneToOne
    @JoinColumn(name = "title_type_id")
    private TitleType title_type_id;
    @Column(name = "PRIMARYTITLE")
    private String primaryTitle;
    @Column(name = "ORIGINTITLE")
    private String originTitle;
    @Column(name = "ISADULT")
    private int isAdult;
    @Column(name = "STARTYEAR")
    private int startYear;
    @Column(name = "ENDYEAR")
    private int endYear;
    @Column(name = "RATING")
    private float rating;
    @Column(name = "VOTES")
    private int votes;
    @Column(name = "IMBD_ID")
    private String imbd_id;
    @Column(name = "OVERVIEW")
    private String overview;
    @Column(name = "POSTER_PATH")
    private String poster_path;

    @Embedded
    @OneToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "MOVIE_X_GENRE", joinColumns = {@JoinColumn(name = "movie_id")},inverseJoinColumns = {@JoinColumn(name = "genre_id")})
    private List<Genre> genres;

    @Transient
    @OneToMany(mappedBy = "movie")
    private List<Review> reviewList;

    public Movie(){
    }
    public float getRating() {
        return rating;
    }

    public List<Genre> getGenres() {
        return genres;
    }

    public void setGenres(List<Genre> genres) {
        this.genres = genres;
    }

    public int getEndYear() {
        return endYear;
    }

    public int getIsAdult() {
        return isAdult;
    }

    public String getMovie_id() {
        return movie_id;
    }

    public int getStartYear() {
        return startYear;
    }

    public TitleType getTitle_type_id() {
        return title_type_id;
    }

    public int getVotes() {
        return votes;
    }

    public String getImbd_id() {
        return imbd_id;
    }

    public String getOriginTitle() {
        return originTitle;
    }

    public String getOverview() {
        return overview;
    }

    public String getPoster_path() {
        return poster_path;
    }

    public String getPrimaryTitle() {
        return primaryTitle;
    }

    public void setEndYear(int endYear) {
        this.endYear = endYear;
    }

    public void setImbd_id(String imbd_id) {
        this.imbd_id = imbd_id;
    }

    public void setIsAdult(int isAdult) {
        this.isAdult = isAdult;
    }

    public void setMovie_id(String movie_id) {
        this.movie_id = movie_id;
    }

    public void setOriginTitle(String originTitle) {
        this.originTitle = originTitle;
    }

    public void setPrimaryTitle(String primaryTitle) {
        this.primaryTitle = primaryTitle;
    }

    public void setOverview(String overview) {
        this.overview = overview;
    }

    public void setPoster_path(String poster_path) {
        this.poster_path = poster_path;
    }

    public void setRating(float rating) {
        this.rating = rating;
    }

    public void setReviewList(List<Review> reviewList) {
        this.reviewList = reviewList;
    }

    public void setTitle_type_id(TitleType title_type_id) {
        this.title_type_id = title_type_id;
    }

    public void setStartYear(int startYear) {
        this.startYear = startYear;
    }

    public void setVotes(int votes) {
        this.votes = votes;
    }

   public List<Review> getReviewList(){return reviewList;}


}
