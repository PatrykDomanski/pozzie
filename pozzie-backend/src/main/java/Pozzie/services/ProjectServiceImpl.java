package Pozzie.services;

import Pozzie.model.*;
import Pozzie.repositories.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

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

    @Override
    public List<Position> getAllPositionsFromProject(int id) {
        Project project = projectRepository.findById(id)
                .orElse(null);
        if(project == null){
            return null;
        }
        List<KeyWord> projectKeyWords = project.getKeyWords();
        List<Position> positionList = new ArrayList<Position>();
        for(KeyWord keyWord : projectKeyWords){
            for(Position position : keyWord.getPositions()){
                positionList.add(position);
            }
        }

        return positionList;
    }
}
