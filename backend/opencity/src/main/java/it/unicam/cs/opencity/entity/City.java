package it.unicam.cs.opencity.entity;

import jakarta.persistence.*;

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
    private float longitude;
    private float latitude;

    public City(String cadastralCode, String name, String region, Integer istatCode, float longitude, float latitude) {
        this.cadastralCode = cadastralCode;
        this.name = name;
        this.region = region;
        this.istatCode = istatCode;
        this.longitude = longitude;
        this.latitude = latitude;
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

    public float getLatitude() {
        return latitude;
    }

    public void setLatitude(float latitude) {
        this.latitude = latitude;
    }

    public float getLongitude() {
        return longitude;
    }

    public void setLongitude(float longitude) {
        this.longitude = longitude;
    }

}
