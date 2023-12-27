package it.unicam.cs.opencity.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "Media")
public class Media {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String path;

    public Media(Integer id, String name, String path) {
        this.id = id;
        this.name = name;
        this.path = path;
    }

    public Media() { }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }
}
