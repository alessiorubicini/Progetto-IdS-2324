package it.unicam.cs.opencity.entity;

import it.unicam.cs.opencity.entity.point.Point;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "City")
public class City {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(unique = true)
    private String cadastralCode;
    private String name;
    private String region;
    private Integer istatCode;
    @OneToMany(mappedBy = "city", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Point> points;

    public City(Integer id, String cadastralCode, String name, String region, Integer istatCode, List<Point> points) {
        this.id = id;
        this.cadastralCode = cadastralCode;
        this.name = name;
        this.region = region;
        this.istatCode = istatCode;
        this.points = points;
    }

    public City() { }

    public Integer getId() {
        return id;
    }

    public String getCadastralCode() {
        return cadastralCode;
    }

    public void setCadastralCode(String cadastralCode) {
        this.cadastralCode = cadastralCode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public Integer getIstatCode() {
        return istatCode;
    }

    public void setIstatCode(Integer istatCode) {
        this.istatCode = istatCode;
    }

    public List<Point> getPoints() {
        return points;
    }

    public void setPoints(List<Point> points) {
        this.points = points;
    }
}
