package it.unicam.cs.opencity.util;

import it.unicam.cs.opencity.entity.Participation;
import it.unicam.cs.opencity.entity.Role;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserDTO {

    private int id;
    private String name;
    private String surname;
    private String email;
    private String username;
    private List<Participation> participations;

    public UserDTO(int id, String name, String surname, String email, String username, List<Participation> participations){
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.username = username;
        this.participations = participations;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Participation> getParticipations() {
        return participations;
    }

    public void setParticipations(List<Participation> participations) {
        this.participations = participations;
    }
}
