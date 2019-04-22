package Pozzie.services;

import Pozzie.model.Note;
import Pozzie.model.Project;
import Pozzie.model.Type;
import Pozzie.model.User;
import Pozzie.repositories.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class ProjectServiceImpl implements ProjectService {

    @Autowired
    ProjectRepository projectRepository;

    @Override
    public String addProject(User user, String name) {
        Project project = new Project();
        project.setName(name);
        project.setUser(user);
        projectRepository.save(project);
        return "Added";
    }

    @Override
    public String editProject(int id, String name) {
        Project project = projectRepository.findById(id)
                .orElse(null);
        if(project == null){
            return "Error";
        }
        project.setName(name);
        projectRepository.save(project);
        return "Added";
    }

    @Override
    public String deleteProject(int id) {
        projectRepository.deleteById(id);
        return "Deleted";
    }
}
