package it.unicam.cs.opencity.entity;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;

import java.util.Map;

public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id;
    private String fiscalCode;
    private String name;
    private String surname;
    private String email;
    private String password;

    @ManyToMany(mappedBy = "User")
    private Map<Role, City> roles;

    public User(Integer id, String fiscalCode, String name, String surname, String email, String password, Map<Role, City> roles) {
        this.id = id;
        this.fiscalCode = fiscalCode;
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.password = password;
        this.roles = roles;
    }

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

    public Map<Role, City> getRoles() {
        return roles;
    }

    public void setRoles(Map<Role, City> roles) {
        this.roles = roles;
    }
}
