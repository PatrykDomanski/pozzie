package Pozzie.controllers;

import Pozzie.model.Position;
import Pozzie.services.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ProjectController {

    @Autowired
    ProjectService projectService;

    @RequestMapping("/give/positions/{id}")
    @ResponseBody
    public List<Position> getPositions(@PathVariable("id") int id){
        return projectService.getAllPositionsFromProject(id);
    }
}
