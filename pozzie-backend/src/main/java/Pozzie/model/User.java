package Pozzie.model;

import javax.persistence.*;
import java.util.List;

@Entity
public class User {
    @Id
    @Column(name = "id")
    private String id;

    @Column(name = "username")
    private String username;

    @Column(name = "email")
    private String email;

    @Column(name = "role")
    private Integer role;

    @Column(name = "name")
    private String name;

    @OneToMany(mappedBy = "id")
    private List<Position> keywords;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "projectId", referencedColumnName = "id")
    private Project project;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getRole() {
        return role;
    }

    public void setRole(Integer role) {
        this.role = role;
    }

    public List<Position> getKeywords() {
        return keywords;
    }

    public void setKeywords(List<Position> keywords) {
        this.keywords = keywords;
    }

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
