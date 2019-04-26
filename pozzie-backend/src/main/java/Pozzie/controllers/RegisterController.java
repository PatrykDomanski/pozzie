package Pozzie.controllers;

import Pozzie.model.User;
import Pozzie.services.UserService;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.security.auth.login.Configuration;
import java.security.Policy;
import java.util.concurrent.ExecutionException;

@RestController
public class RegisterController {

    @Autowired
    UserService userService;

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String registerUser(@RequestHeader(value = "ID-TOKEN") String idToken) throws Exception{
        String userId = this.getUserIdFromIdToken(idToken);
        if(userId != null){
            User user = new User();

            FirebaseToken token = FirebaseAuth.getInstance().verifyIdTokenAsync(idToken).get();
            user.setId(token.getUid());
            user.setEmail(token.getEmail());
            user.setName(token.getName());
            userService.addUser(user);
            return "Added";
        }
        return "aa";
    }

    public String getUserIdFromIdToken(String idToken) throws Exception {
        String userId = null;
        try {
            userId = FirebaseAuth.getInstance().verifyIdTokenAsync(idToken).get().getUid();
        } catch (InterruptedException | ExecutionException e) {
            throw new Exception("User Not Authenticated");
        }
        return userId;
    }

}
