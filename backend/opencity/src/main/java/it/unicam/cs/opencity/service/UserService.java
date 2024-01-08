package it.unicam.cs.opencity.service;

import it.unicam.cs.opencity.entity.User;
import it.unicam.cs.opencity.repository.ParticipationRepository;
import it.unicam.cs.opencity.util.UserDTO;
import it.unicam.cs.opencity.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class UserService implements UserDetailsService {

    private final UserRepository userRepository;
    private final ParticipationRepository participationRepository;

    @Autowired
    public UserService(UserRepository userRepository, ParticipationRepository participationRepository) {
        this.userRepository = userRepository;
        this.participationRepository = participationRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException("User not found with username: " + username);
        }
        return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), new ArrayList<>());
    }

    public UserDTO convertToDTO(User user){
        return new UserDTO(user.getId(), user.getName(),user.getSurname(), user.getEmail(), user.getUsername(), participationRepository.findByIdUserId(user.getId()));
    }

    public void addUser(User user) {
        this.userRepository.save(user);
    }

    public Iterable<User> getAllUsers() {
        return userRepository.findAll();
    }

    public Optional<User> getUserDetails(Integer id) {
        return userRepository.findById(id);
    }

    public User getUserDetails(String username) {
        return userRepository.findByUsername(username);
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
