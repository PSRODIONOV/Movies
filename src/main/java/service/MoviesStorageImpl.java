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
    public void addReview(Review review){
        review.setAuthor(US.currentUser.getlogin());
        review.setDate_and_time(new java.sql.Date(Calendar.getInstance().getTime().getTime()));
        if(mas.addReview(review))
            return;
    }

    @Override
    public boolean updateReview(Review review){
        return  mas.updateReview(review);
    }

    @Override
    public List<Review> getMyAllReview(){
        return mas.getMyAllReview(US.currentUser);
    }

    @Override
    public void delReviewById(long id){
        if(mas.delReviewById(id))
            return;
    }

    @Override
    public List<Genre> getAllGenre(){
        return mas.getAllGenre();
    }

    @Override
    public List<TitleType> getAllTitleType(){
        return mas.getAllTitleType();
    }
    /*MoviesStorageImpl(){
        readMoviesFile("./src/main/resources/MoviesList1.csv");
    }*/

   /*public static service.MoviesStorageImpl getInstance(){
        if(instance == null){
            synchronized (service.MoviesStorageImpl.class){
                if(instance == null)
                    instance = new service.MoviesStorageImpl();
            }
        }
        return instance;
    }*/

    /*public Movie getMovieById(int id){
        for (Movie m: movieList) {
            if(m.getID() == id){
                return m;
            }
        }
        return null;
    }*/

    /*public List<Movie> getFoundMovieList(){
        return foundMovieList;
    }*/

    /*public boolean searchMovie(String substr){
        foundMovieList.clear();
        for (Movie a: movieList) {
            if(a.getPrimaryTitle().toLowerCase().contains(substr.toLowerCase()))
                foundMovieList.add(a);
        }
        if(foundMovieList.isEmpty())
            return false;
        Collections.sort(foundMovieList, new Comparator<Movie>() {
            @Override
            public int compare(Movie o1, Movie o2) {
                return (int)((o2.getRating() - o1.getRating())*10);
            }
        });
            return true;
    }
    */

    /*public boolean delComment(int idMovie, long idComment){
        Movie temp = getMovieById(idMovie);
        if(temp != null) {
            if (temp.delComment(idComment))
                return true;
            else
                return false;
        }
        return false;
    }*/

    /*public boolean editComment(int idMovie, long idComment, String newText){
        Movie temp = getMovieById(idMovie);
        if(temp != null) {
            if (temp.editCommentById(idComment, newText))
                return true;
            else
                return false;
        }
        return false;
    }*/

    /*public boolean addReview(int idMovie, String authtor, String text, float rating){
        Date currentDate = new Date();
        for (Movie m: movieList) {
            if(m.getID() == idMovie) {
                m.addReview(new Review((m.getCountComments()+1), authtor, text, rating, currentDate.toString()));
                return true;
            }
        }
        return false;
    }*/

    /*public String getNameById(int id){
        for(Movie m: movieList){
            if(m.getID() == id){
                return m.getPrimaryTitle();
            }
        }
        return null;
    }*/

    /*public void readMoviesFile(String path){
        File fin = new File(path);
        try {

            BufferedReader buf = new BufferedReader(new FileReader(fin));
            String line;
            while((line = buf.readLine())!= null) {
                String[] arg = line.split(";");
                movieList.add(new Movie(Integer.parseInt(arg[0]), arg[1], arg[2], arg[3], Float.parseFloat(arg[4].replace(',','.')), arg[5], arg[6]));
            }

        }
        catch(IOException e){
            e.printStackTrace();
        }
    }*/
}