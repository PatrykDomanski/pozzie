package Pozzie.model;

import org.codehaus.jackson.annotate.JsonBackReference;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Position {
    @Id
    @GeneratedValue
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "keyWord_id", nullable = false)
    private KeyWord keyWord;

    @Column(name = "date")
    private Date date;

    @Column(name = "position")
    private Integer position;

    @Column(name = "url")
    private String url;

    public Position() {}

    public KeyWord getKeyWord() {
        return keyWord;
    }

    public void setKeyWord(KeyWord keyWord) {
        this.keyWord = keyWord;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Integer getPosition() {
        return position;
    }

    public void setPosition(Integer position) {
        this.position = position;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }


}
