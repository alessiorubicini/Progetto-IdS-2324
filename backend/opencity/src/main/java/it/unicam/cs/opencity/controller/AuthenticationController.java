package it.unicam.cs.opencity.controller;

import it.unicam.cs.opencity.entity.User;
import it.unicam.cs.opencity.service.UserService;
import it.unicam.cs.opencity.util.JwtTokenProvider;
import it.unicam.cs.opencity.util.UserCredentials;
import it.unicam.cs.opencity.util.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthenticationController {

    private final AuthenticationManager authenticationManager;
    private final PasswordEncoder passwordEncoder;
    private final JwtTokenProvider jwtTokenProvider;
    private final UserService userService;

    @Autowired
    public AuthenticationController(AuthenticationManager authenticationManager, PasswordEncoder passwordEncoder, JwtTokenProvider jwtTokenProvider, UserService userService) {
        this.authenticationManager = authenticationManager;
        this.passwordEncoder = passwordEncoder;
        this.jwtTokenProvider = jwtTokenProvider;
        this.userService = userService;
    }

    @PostMapping("/login")
    public ResponseEntity<Object> login(@RequestBody UserCredentials credentials) {
        System.out.println("gnao 1");
        try {
            System.out.println("gnao 1.1");
            Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(credentials.getUsername(), credentials.getPassword()));
            System.out.println("gnao 2");
            UserDTO userDTO = this.userService.convertToDTO(userService.getUserDetails(credentials.getUsername()));
            System.out.println("gnao 3");
            String token = jwtTokenProvider.generate(userDTO.getId(), authentication.getName());
            System.out.println("gnao 4");
            return ResponseEntity.ok().headers(authorizationHeaders(token)).body(userDTO);
        } catch (BadCredentialsException e) {
            System.out.println("maragnao");
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid credentials: " + e.getLocalizedMessage());
        }
    }

    @PostMapping("/signup")
    public ResponseEntity<Object> signup(@RequestBody User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userService.addUser(user);
        return ResponseEntity.ok("User added");
    }

    // Utility method to build the necessary http headers for bearer authorization
    private HttpHeaders authorizationHeaders(String token) {
        HttpHeaders headers = new HttpHeaders();
        headers.add("Authorization", "Bearer " + token);
        return headers;
    }

}
