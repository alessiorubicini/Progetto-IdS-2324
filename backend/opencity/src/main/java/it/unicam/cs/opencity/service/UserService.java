package it.unicam.cs.opencity.service;

import it.unicam.cs.opencity.entity.Participation;
import it.unicam.cs.opencity.entity.ParticipationId;
import it.unicam.cs.opencity.entity.Role;
import it.unicam.cs.opencity.entity.User;
import it.unicam.cs.opencity.repository.ParticipationRepository;
import it.unicam.cs.opencity.repository.RoleRepository;
import it.unicam.cs.opencity.util.UserDTO;
import it.unicam.cs.opencity.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserService implements UserDetailsService {

    private final UserRepository userRepository;
    private final ParticipationRepository participationRepository;
    private final CityService cityService;
    private final RoleRepository roleRepository;

    @Autowired
    public UserService(UserRepository userRepository, ParticipationRepository participationRepository, CityService cityService, RoleRepository roleRepository) {
        this.userRepository = userRepository;
        this.participationRepository = participationRepository;
        this.cityService = cityService;
        this.roleRepository = roleRepository;
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

    public void addRoleToUser(Integer roleId, Integer userId, Integer cityId){

        ParticipationId participationId = new ParticipationId();
        participationId.setUserId(userId);
        participationId.setCity(cityService.getCityDetails(cityId).get());
        participationId.setRole(roleRepository.getReferenceById(roleId));

        Participation participation = new Participation();
        participation.setId(participationId);

        this.participationRepository.save(participation);
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

    public List<Role> getAvailableRoles(){
        return roleRepository.findAll();
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
