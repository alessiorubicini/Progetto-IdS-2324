package it.unicam.cs.opencity.service;

import it.unicam.cs.opencity.entity.User;
import it.unicam.cs.opencity.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public Iterable<User> getAllUsers() {
        return this.userRepository.findAll();
    }


}
