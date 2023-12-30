package it.unicam.cs.opencity.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "City")
public class City {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(unique = true)
    private String cadastralCode;
    private String name;
    private String region;
    private Integer istatCode;
    @OneToMany(mappedBy = "city", cascade = CascadeType.ALL, orphanRemoval = true) @JsonManagedReference
    private List<Point> points;
    @OneToMany(mappedBy = "city", cascade = CascadeType.ALL, orphanRemoval = true) @JsonManagedReference
    private List<Contest> contests;

    public City(String cadastralCode, String name, String region, Integer istatCode, List<Point> points, List<Contest> contests) {
        this.cadastralCode = cadastralCode;
        this.name = name;
        this.region = region;
        this.istatCode = istatCode;
        this.points = points;
        this.contests = contests;
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

    public List<Contest> getContests() {
        return contests;
    }

    public void setContests(List<Contest> contests) {
        this.contests = contests;
    }

    public List<Content> getAllContents() {
        List<Content> contents = new ArrayList<>();
        for (Point point : this.points) {
            contents.addAll(point.getContents());
        }
        return contents;
    }
}
