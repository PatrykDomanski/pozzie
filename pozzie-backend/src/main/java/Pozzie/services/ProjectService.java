package Pozzie.services;

import Pozzie.model.Position;
import Pozzie.model.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ProjectService {
    public String addProject(User user, String name);
    public String editProject(int id, String name);
    public String deleteProject(int id);

    public List<Position> getAllPositionsFromProject(int id);
}
