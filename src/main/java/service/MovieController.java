package service;

import org.springframework.beans.factory.annotation.Autowired;

import javax.ws.rs.*;
import java.util.List;


@Path("/movie")
@Consumes("application/json")
@Produces("application/json")
public class MovieController{
    @Autowired
    private MoviesStorageImpl MS;
    @GET
    @Path("/view/{key}={value}")
    public List<Movie> find(@PathParam("key") String key, @PathParam("value") String value){
        return MS.searchMovie(key, value);
    }

    @GET
    @Path("/{id}")
    public Movie getMovie(@PathParam("id") String id){
        return MS.getMovieById(id);
    }

    @POST
    @Path("/{id}/review")
    public String addReview(@PathParam("id") String id, Review review){
        review.setMovie_id(id);
        if(MS.addReview(review))
            return "Review added";
        return "Error.";
    }

    @PUT
    @Path("/review")
    public String updateReview(Review review){
        if(!MS.updateReview(review))
            return "Error";
        return "Update complete";
    }

    @POST
    @Path("/review/view")
    public List<Review> getMyAllReview(){
        return MS.getMyAllReview();
    }

    @DELETE
    @Path("review/{id}")
    public String delReview(@PathParam("id") int id){
        if(MS.delReviewById(id))
            return "Review deleted.";
        return "Error.";
    }

    @GET
    @Path("/genre")
    public List<Genre> getAllGenre(){
        return MS.getAllGenre();
    }

    @GET
    @Path("/titletype")
    public List<TitleType> getAllTitleType(){
        return MS.getAllTitleType();
    }

}