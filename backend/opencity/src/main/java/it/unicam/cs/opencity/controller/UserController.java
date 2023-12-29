package it.unicam.cs.opencity.controller;

import it.unicam.cs.opencity.entity.User;
import it.unicam.cs.opencity.service.RoleService;
import it.unicam.cs.opencity.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;
    private final RoleService roleService;

    @Autowired
    public UserController(UserService userService, RoleService roleService) {
        this.userService = userService;
        this.roleService = roleService;
    }

    @GetMapping("/")
    public ResponseEntity<Object> getAllUsers() {
        return ResponseEntity.ok(userService.getAllUsers());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getUserDetails(@PathVariable("id") String id) {
        Optional<User> user = userService.getUserDetails(Integer.parseInt(id));
        if(user.isPresent()) {
            return ResponseEntity.ok(user.get());
        } else {
            return ResponseEntity.status(404).body("User not found");
        }
    }

    @GetMapping("/{id}/contents")
    public ResponseEntity<Object> getUserContents(@PathVariable("id") String id) {

        // TODO: implementare
        return null;
    }

    @DeleteMapping("/remove/{id}")
    public ResponseEntity<Object> removeUser(@PathVariable("id") String id) {
        if(userService.removeUser(Integer.parseInt(id))) {
            return ResponseEntity.ok("User successfully removed");
        } else {
            return ResponseEntity.status(404).body("User not found");
        }
    }

    @GetMapping("/roles")
    public ResponseEntity<Object> getRoles() {
        return ResponseEntity.ok(roleService.getRoles());
    }

}
