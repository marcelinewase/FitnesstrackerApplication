package com.fitness.serviceLayer;

import com.fitness.model.UserFitness;
import com.fitness.repository.UserRepository;
import org.apache.catalina.User;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    public UserFitness registerUser(String login, String password, String email) {
        if (login == null || password == null) {
            return  null;

    }else {
            UserFitness user = new UserFitness();
            user.setLogin(login);
            user.setPassword(password);
            user.setEmail(email);
            return userRepository.save(user);
        }
    }


    public UserFitness authenticate(String email, String password) {
     Optional<UserFitness> userOptional=userRepository.findByEmailAndPassword(email, password);
     return userOptional.isPresent() ? userOptional.get():null;

    }
}
