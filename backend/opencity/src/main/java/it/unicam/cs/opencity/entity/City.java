package it.unicam.cs.opencity.entity;

import it.unicam.cs.opencity.entity.point.Point;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

import java.util.List;

public class City {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id;
    private String cadastralCode;
    private String name;
    private String region;
    private Integer istatCode;

    @OneToMany(mappedBy = "City")
    private List<Point> pointsOfInterest;

    public City(Integer id, String cadastralCode, String name, String region, Integer istatCode, List<Point> pointsOfInterest) {
        this.id = id;
        this.cadastralCode = cadastralCode;
        this.name = name;
        this.region = region;
        this.istatCode = istatCode;
        this.pointsOfInterest = pointsOfInterest;
    }

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

    public List<Point> getPointsOfInterest() {
        return pointsOfInterest;
    }

    public void setPointsOfInterest(List<Point> pointsOfInterest) {
        this.pointsOfInterest = pointsOfInterest;
    }
}
