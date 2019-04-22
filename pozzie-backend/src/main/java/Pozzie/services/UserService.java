package Pozzie.services;

import Pozzie.model.User;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface UserService {

    public User addUser(User user);

    public void deleteUser(int id);
    public User getUserById(int id);
    public List<User> getAllUsers();
    public void saveUser(String idToken) throws Exception;

}
