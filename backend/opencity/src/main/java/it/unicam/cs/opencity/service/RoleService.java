package it.unicam.cs.opencity.service;

import it.unicam.cs.opencity.entity.Role;
import it.unicam.cs.opencity.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class RoleService {

    private final RoleRepository roleRepository;

    @Autowired
    public RoleService(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    public Iterable<Role> getRoles() {
        return roleRepository.findAll();
    }

    public Optional<Role> getRoleDetails(Integer idRole) {return roleRepository.findById(idRole);}

}
