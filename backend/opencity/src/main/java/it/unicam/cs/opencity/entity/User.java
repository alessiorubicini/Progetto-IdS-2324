package it.unicam.cs.opencity.entity;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "User")
public class User {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String surname;
    private String username;
    @Column(name = "fiscalCode")
    private String fiscalCode;
    @Column(unique = true)
    private String email;
    private String password;

    @OneToMany(mappedBy = "id.userId", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Participation> participations;

    @OneToMany(mappedBy = "id.userId", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Favorite> favorites;

    public User(String name, String surname, String username, String fiscalCode, String email, String password) {
        this.name = name;
        this.surname = surname;
        this.username = username;
        this.fiscalCode = fiscalCode;
        this.email = email;
        this.password = password;
        this.favorites = new ArrayList<>();
        this.participations = new ArrayList<>();
    }

    public User() { }

    public Integer getId() {
        return id;
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

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getFiscalCode() {
        return fiscalCode;
    }

    public void setFiscalCode(String fiscalCode) {
        this.fiscalCode = fiscalCode;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Participation> getParticipations() {
        return participations;
    }

    public void setParticipations(List<Participation> participations) {
        this.participations = participations;
    }

    public void addParticipation(Participation participation) {
        this.participations.add(participation);
    }

    public void addFavorite(Favorite favorite){
        this.favorites.add(favorite);
    }

}
