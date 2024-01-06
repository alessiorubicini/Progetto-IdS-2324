package it.unicam.cs.opencity.controller;

import it.unicam.cs.opencity.entity.User;
import it.unicam.cs.opencity.service.RoleService;
import it.unicam.cs.opencity.service.UserService;
import it.unicam.cs.opencity.util.JwtTokenProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;
    private final RoleService roleService;
    private final JwtTokenProvider jwtTokenProvider;

    @Autowired
    public UserController(UserService userService, RoleService roleService, JwtTokenProvider jwtTokenProvider) {
        this.userService = userService;
        this.roleService = roleService;
        this.jwtTokenProvider = jwtTokenProvider;
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

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> removeUser(@PathVariable("id") String id, @RequestHeader MultiValueMap<String, String> headers) {
        if(hasPermission(headers, id)) {
            if(userService.removeUser(Integer.parseInt(id))) {
                return ResponseEntity.ok("User successfully removed");
            } else {
                return ResponseEntity.status(404).body("User not found");
            }
        } else {
            return ResponseEntity.status(403).body("Not authorized to remove this user");
        }
    }
    @GetMapping("/roles")
    public ResponseEntity<Object> getRoles() {
        return ResponseEntity.ok(roleService.getRoles());
    }

    private boolean hasPermission(MultiValueMap<String, String> headers, String userId) {
        String token = headers.get("authorization").get(0).substring(7);
        String id = jwtTokenProvider.extractId(token);
        return id.equals(userId);
    }

}
