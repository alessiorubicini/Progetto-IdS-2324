package it.unicam.cs.opencity.entity;

import java.util.List;

public class UserInfo {

    private Integer id;
    private String username;
    private List<Participation> roles;

    public UserInfo(User user) {
        this.id = user.getId();
        this.username = user.getUsername();
        this.roles = user.getRoles();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public List<Participation> getRoles() {
        return roles;
    }

    public void setRoles(List<Participation> roles) {
        this.roles = roles;
    }
}
