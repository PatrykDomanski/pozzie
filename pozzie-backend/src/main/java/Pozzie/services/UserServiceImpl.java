package Pozzie.services;

import Pozzie.model.User;
import Pozzie.repositories.UserRepository;
import com.google.firebase.auth.FirebaseAuth;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.ExecutionException;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public User addUser(User user){
        return this.userRepository.save(user);
    }

    @Override
    public void deleteUser(int id) {
        this.userRepository.deleteById(id);
    }

    @Override
    public User getUserById(int id) {
        return this.userRepository.findById(id)
                .orElse(null);
    }

    @Override
    public List<User> getAllUsers() {
        return (List<User>) this.userRepository.findAll();
    }

    @Override
    public void saveUser(String idToken) throws Exception {
        String uid = getUserIdFromIdToken(idToken);
        System.out.println("User Id :: " + uid);

    }

    public String getUserIdFromIdToken(String idToken) throws Exception {
        String uid = null;
        try {
            uid = FirebaseAuth.getInstance().verifyIdTokenAsync(idToken).get().getUid();
        } catch (InterruptedException | ExecutionException e) {
            throw new Exception("User Not Authenticated");
        }
        return uid;
    }
}
