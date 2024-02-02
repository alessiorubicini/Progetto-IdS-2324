package it.unicam.cs.opencity.entity;

import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

import java.io.Serializable;

@Embeddable
public class ParticipationId implements Serializable {

    @JoinColumn(name = "userId")
    private Integer userId;

    @JoinColumn(name = "cityId")
    private Integer cityId;

    @ManyToOne
    @JoinColumn(name = "roleId")
    private Role role;

    public ParticipationId() {
    }

    public ParticipationId(Integer userId, Integer cityId, Role role) {
        this.userId = userId;
        this.cityId = cityId;
        this.role = role;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getCityId() {
        return cityId;
    }

    public void setCityId(Integer city) {
        this.cityId = city;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }
}
