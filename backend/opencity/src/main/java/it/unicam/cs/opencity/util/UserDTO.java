package it.unicam.cs.opencity.util;

import it.unicam.cs.opencity.entity.Participation;

import java.util.List;

public class UserDTO {

    private int id;
    private String username;
    private List<Participation> participations;

    public UserDTO(int id, String username, List<Participation> participations){
        this.id = id;
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

    public List<Participation> getParticipations() {
        return participations;
    }

    public void setParticipations(List<Participation> participations) {
        this.participations = participations;
    }

}
