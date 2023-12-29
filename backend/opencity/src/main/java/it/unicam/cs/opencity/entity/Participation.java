package it.unicam.cs.opencity.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "Participation")
public class Participation {

    @Id @ManyToOne @JoinColumn(name = "userId")
    private User user;

    @Id @ManyToOne @JoinColumn(name = "cityId")
    private City city;

    @Id @ManyToOne @JoinColumn(name = "roleId")
    private Role role;

    public User getUser() {
        return user;
    }

    public City getCity() {
        return city;
    }

    public Role getRole() {
        return role;
    }
}
