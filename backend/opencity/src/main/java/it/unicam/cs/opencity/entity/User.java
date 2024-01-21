package it.unicam.cs.opencity.entity;

import jakarta.persistence.*;

import java.util.ArrayList;

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

    @OneToMany(mappedBy = "id.userId")
    private ArrayList<Participation> participations;

//    @OneToMany(mappedBy = "id.userId")
//    private ArrayList<Favorite> favorites;

    @ManyToMany
    @JoinTable(
            name = "favorite",
            joinColumns = @JoinColumn(name = "userId"),
            inverseJoinColumns = @JoinColumn(name = "contentId")
    )
    private ArrayList<Content> favorites;


    public User(String name, String surname, String username, String fiscalCode, String email, String password) {
        this.name = name;
        this.surname = surname;
        this.username = username;
        this.fiscalCode = fiscalCode;
        this.email = email;
        this.password = password;
        this.participations = new ArrayList<>();
        this.favorites = new ArrayList<>();
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

    public void addRole(City city, Role role)
    {
        ParticipationId participationId = new ParticipationId();
        participationId.setUserId(this.id);
        participationId.setCity(city);
        participationId.setRole(role);

        Participation participation = new Participation();
        participation.setId(participationId);

        participations.add(participation);
    }

    public void addFavorite(Content content){
//        FavoriteId favoriteId = new FavoriteId();
//        favoriteId.setContent(content);
//        favoriteId.setUserId(this.id);
//
//        Favorite favorite = new Favorite();
//        favorite.setId(favoriteId);
        favorites.add(content);
    }

}
