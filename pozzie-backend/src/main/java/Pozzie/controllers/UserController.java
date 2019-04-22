package Pozzie.controllers;

import Pozzie.model.LoginForm;
import Pozzie.model.User;
import Pozzie.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@RestController
@Component
public class UserController {
    @Autowired
    UserService userService;


    @RequestMapping(value = "/user/all")
    public @ResponseBody
    Iterable<User> getAllUsers() {
        // This returns a JSON or XML with the users
        return userService.getAllUsers();
    }

    @RequestMapping(value = "/user/register", method = RequestMethod.POST)
    public @ResponseBody
    String registerUser(@RequestBody @Valid @NotNull LoginForm user){
        User newUser = new User();

        newUser.setUsername(user.getName());
        newUser.setPassword(user.getPassword());
        newUser.setEnabled(false);
        newUser.setRole(1);
        userService.addUser(newUser);
        return "supa";
    }

    @RequestMapping(value = "/user/save")
    @ResponseBody
    public String save(@RequestHeader(value="ID-TOKEN") String idToken) throws Exception {
        userService.saveUser(idToken);
        return "aaa";
    }
}
