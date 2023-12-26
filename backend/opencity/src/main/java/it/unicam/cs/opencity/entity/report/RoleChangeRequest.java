package it.unicam.cs.opencity.entity.report;

import it.unicam.cs.opencity.entity.*;
import jakarta.persistence.*;

@Entity
@Table(name = "RoleChangeRequest")
public class RoleChangeRequest extends Report {

    @Id @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id;
    @ManyToOne @JoinColumn(name = "userId")
    private User author;
    @ManyToOne @JoinColumn(name = "requiredRoleId")
    private Role requiredRole;
    @ManyToOne @JoinColumn(name = "cityId")
    private City city;
    @Enumerated(EnumType.STRING)
    private RequestStatus status;

    public RoleChangeRequest(Integer id, User author, Role requiredRole, City city, RequestStatus status) {
        this.id = id;
        this.author = author;
        this.requiredRole = requiredRole;
        this.city = city;
        this.status = status;
    }

    public RoleChangeRequest() { }

    public Integer getId() {
        return id;
    }

    public User getAuthor() {
        return author;
    }

    public void setAuthor(User author) {
        this.author = author;
    }

    public Role getRequiredRole() {
        return requiredRole;
    }

    public void setRequiredRole(Role requiredRole) {
        this.requiredRole = requiredRole;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    public RequestStatus getStatus() {
        return status;
    }

    public void setStatus(RequestStatus status) {
        this.status = status;
    }
}


