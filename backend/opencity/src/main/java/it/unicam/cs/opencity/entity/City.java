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
    private float latitude;
    private float longitude;

    public City(String cadastralCode, String name, String region, Integer istatCode, float latitude, float longitude) {
        this.cadastralCode = cadastralCode;
        this.name = name;
        this.region = region;
        this.istatCode = istatCode;
        this.latitude = latitude;
        this.longitude = longitude;
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
