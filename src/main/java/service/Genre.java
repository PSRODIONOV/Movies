package service;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "DIC_GENRE")
public class Genre {

    @Id
    @Column(name = "GENRE_ID")
    private long genre_id;
    @Column(name = "GENRE")
    private String genre;

    public Genre() {
    }

    public long getGenre_id() { return genre_id; }

    public void setGenre_id(long genre_id) {
        this.genre_id = genre_id;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }
}
