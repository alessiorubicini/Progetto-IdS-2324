package it.unicam.cs.opencity.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "Role")
public class Role {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(unique = true)
    private String title;
    private String description;

    public Role(String title, String description) {
        this.title = title;
        this.description = description;
    }

    public Role() { }

    public Integer getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
