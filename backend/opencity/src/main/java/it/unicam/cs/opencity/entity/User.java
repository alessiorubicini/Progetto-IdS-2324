package it.unicam.cs.opencity.entity;

import jakarta.persistence.*;

import java.util.Map;

@Entity
@Table(name = "User")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String surname;
    private String username;
    @Column(name = "fiscalCode")
    private String fiscalCode;
    //@Column(unique = true)
    private String email;
    private String password;

    // TODO: sistemare relazione ternaria ruoli
    //@ManyToMany(mappedBy = "User") private Map<City, Role> roles;

    public User(Integer id, String fiscalCode, String name, String surname, String email, String password) {
        this.id = id;
        this.fiscalCode = fiscalCode;
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.password = password;
        //this.roles = roles;
    }

    public User() { }

    public Integer getId() {
        return id;
    }

    public String getFiscalCode() {
        return fiscalCode;
    }

    public void setFiscalCode(String fiscalCode) {
        this.fiscalCode = fiscalCode;
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

    /*public Map<City, Role> getRoles() {
        return roles;
    }

    public void setRoles(Map<City, Role> roles) {
        this.roles = roles;
    }*/
}