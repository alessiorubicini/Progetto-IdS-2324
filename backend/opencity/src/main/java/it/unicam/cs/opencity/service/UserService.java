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
    private final RoleRepository roleRepository;
    private final RoleService roleService;

    @Autowired
    public UserService(UserRepository userRepository, RoleRepository roleRepository, RoleService roleService) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.roleService = roleService;
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
        return new UserDTO(user.getId(), user.getName(),user.getSurname(), user.getEmail(), user.getUsername(), user.getParticipations());
    }

    public boolean addRoleToUser(Integer roleId, Integer userId, Integer cityId){

        Optional<Role> role = roleService.getRoleDetails(roleId);
        if(role.isEmpty())
            return false;

        ParticipationId participationId = new ParticipationId(userId, cityId, role.get());
        Participation participation = new Participation();
        participation.setId(participationId);

        Optional<User> user = this.getUserDetails(userId);
        if(user.isEmpty())
            return false;
        user.get().addParticipation(participation);
        this.userRepository.save(user.get());

        return true;
    }

    public boolean addUser(User user) {
        User savedUser = this.userRepository.save(user);
        return savedUser != null;
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
