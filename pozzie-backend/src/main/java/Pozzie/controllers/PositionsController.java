package Pozzie.controllers;

import Pozzie.model.KeyWord;
import Pozzie.model.Project;
import Pozzie.model.User;
import Pozzie.services.PositionService;
import Pozzie.services.ProjectService;
import Pozzie.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
@RequestMapping("/positions")
@Component
public class PositionsController {

    @Autowired
    private UserService userService;

    @Autowired
    private PositionService positionService;

    @Autowired
    private ProjectService projectService;

    @RequestMapping("/{user_id}")
    @ResponseBody
    public ArrayList<KeyWord> getUserPositions(int user_id){
        User user = userService.getUserById(user_id);
        Project project = user.getProject();
        ArrayList<KeyWord> keyWords = (ArrayList<KeyWord>) project.getKeyWords();


        return keyWords;
    }

}
