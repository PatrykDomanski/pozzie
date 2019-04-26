package Pozzie.model;

import org.codehaus.jackson.annotate.JsonManagedReference;

import javax.jws.Oneway;
import javax.persistence.*;
import java.util.List;

@Entity
public class Project {
    @Id
    @GeneratedValue
    private int id;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id", referencedColumnName = "id")
    private User user;

    @OneToMany(mappedBy = "project")
    private List<KeyWord> keyWords;

    @Column(name = "name")
    private String name;

    @Column(name = "projectUrl")
    private String projectUrl;

    @OneToMany(mappedBy = "project")
    private List<Note> notes;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<KeyWord> getKeyWords() {
        return keyWords;
    }

    public void setKeyWords(List<KeyWord> keyWords) {
        this.keyWords = keyWords;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Note> getNotes() {
        return notes;
    }

    public void setNotes(List<Note> notes) {
        this.notes = notes;
    }

    public String getProjectUrl() {
        return projectUrl;
    }

    public void setProjectUrl(String projectUrl) {
        this.projectUrl = projectUrl;
    }
}
