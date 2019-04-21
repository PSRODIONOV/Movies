package service;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "DIC_TITLE_TYPE")
public class TitleType {

    @Id
    @Column(name = "title_type_id")
    private long title_type_id;
    @Column(name = "title_type")
    private String title_type;

    public TitleType() {
    }

    public long getTitle_type_id() {
        return title_type_id;
    }

    public void setTitle_type_id(long title_type_id) {
        this.title_type_id = title_type_id;
    }

    public String getTitle_type() {
        return title_type;
    }

    public void setTitle_type(String title_type) {
        this.title_type = title_type;
    }
}
