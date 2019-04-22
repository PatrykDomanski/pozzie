package Pozzie.services;

import Pozzie.model.Project;
import Pozzie.model.User;
import org.springframework.stereotype.Service;

@Service
public interface ProjectService {
    public String addProject(User user, String name);
    public String editProject(int id, String name);
    public String deleteProject(int id);
}
