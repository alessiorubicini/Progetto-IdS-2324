package it.unicam.cs.opencity.entity.point;

import it.unicam.cs.opencity.entity.City;
import it.unicam.cs.opencity.entity.Content;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public abstract class Point {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    @ManyToOne @JoinColumn(name = "cityId")
    private City city;
    @OneToMany(mappedBy = "point", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Content> contents;

    public Point(Integer id, String name, City city, List<Content> contents) {
        this.id = id;
        this.name = name;
        this.city = city;
        this.contents = contents;
    }

    public Point() { }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    public List<Content> getContents() {
        return contents;
    }

    public void setContents(List<Content> contents) {
        this.contents = contents;
    }
}
