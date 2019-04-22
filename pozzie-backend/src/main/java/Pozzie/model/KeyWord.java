package Pozzie.model;

import javax.persistence.*;
import java.util.List;

@Entity(name="keyword")
public class KeyWord {
    @Id
    @GeneratedValue
    private int id;

    @ManyToOne
    @JoinColumn(name = "projectId", referencedColumnName = "id")
    private Project project;

    @Column(name = "keyword")
    private String keyword;

    @OneToMany(mappedBy = "id")
    private List<Position> positions;

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

    public List<Position> getPositions() {
        return positions;
    }

    public void setPositions(List<Position> positions) {
        this.positions = positions;
    }
}
