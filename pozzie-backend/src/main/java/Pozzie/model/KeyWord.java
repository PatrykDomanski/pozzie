package Pozzie.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.codehaus.jackson.annotate.JsonBackReference;
import org.codehaus.jackson.annotate.JsonManagedReference;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity(name="keyword")
public class KeyWord {
    @Id
    @GeneratedValue
    private int id;

    @ManyToOne
    @JoinColumn(name = "projectId", referencedColumnName = "id")
    @JsonIgnore
    private Project project;

    @Column(name = "keyword")
    private String keyword;

    @JsonIgnore
    @OneToMany(mappedBy = "keyWord")
    private Set<Position> positions;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

    public Set<Position> getPositions() {
        return positions;
    }

    public void setPositions(Set<Position> positions) {
        this.positions = positions;
    }
}
