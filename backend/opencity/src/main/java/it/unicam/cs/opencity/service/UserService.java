package it.unicam.cs.opencity.service;

import it.unicam.cs.opencity.entity.User;
import it.unicam.cs.opencity.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Optional;

@Service
public class UserService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException("User not found with username: " + username);
        }
        return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), new ArrayList<>());
    }

    // TODO: da rivedere, scritto solo per test
    public void addUser(User user) {
        this.userRepository.save(user);
    }

    /**
     * Returns the complete list of users
     * @return the list of users
     */
    public Iterable<User> getAllUsers() {
        return userRepository.findAll();
    }

    /**
     * Returns the details of the given user
     * @param id the id of the user
     * @return the complete details of the user
     */
    public Optional<User> getUserDetails(Integer id) {
        return userRepository.findById(id);
    }

    /**
     * Removes a user from the repository
     * @param id the id of the user to remove
     * @return true if the users has been removed, false if the user does not exist
     */
    public boolean removeUser(Integer id) {
        if(userRepository.existsById(id)) {
            userRepository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }

}
