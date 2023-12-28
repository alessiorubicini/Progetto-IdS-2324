package it.unicam.cs.opencity.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {

    // TODO: implementare

    @GetMapping("/")
    public ResponseEntity<Object> getAllUsers() {
        return null;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getUserDetails(@PathVariable("id") String id) {
        return null;
    }

    @GetMapping("/{id}/contents")
    public ResponseEntity<Object> getUserContents(@PathVariable("id") String id) {
        return null;
    }

    @DeleteMapping("/remove/{id}")
    public ResponseEntity<Object> removeUser(@PathVariable("id") String id) {
        return null;
    }

}
