package it.unicam.cs.opencity.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "Point")
public class Point {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String description;
    private float longitude;
    private float latitude;
    private float altitude;
    private String imageUrl;
    @ManyToOne @JoinColumn(name = "cityId") @JsonBackReference
    private City city;
    @OneToMany(mappedBy = "point", cascade = CascadeType.ALL, orphanRemoval = true) @JsonManagedReference
    private List<Content> contents;

    public Point(String name, String description, float longitude, float latitude, float altitude, String imageUrl, City city, List<Content> contents) {
        this.name = name;
        this.description = description;
        this.longitude = longitude;
        this.latitude = latitude;
        this.altitude = altitude;
        this.imageUrl = imageUrl;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public float getLongitude() {
        return longitude;
    }

    public void setLongitude(float longitude) {
        this.longitude = longitude;
    }

    public float getLatitude() {
        return latitude;
    }

    public void setLatitude(float latitude) {
        this.latitude = latitude;
    }

    public float getAltitude() {
        return altitude;
    }

    public void setAltitude(float altitude) {
        this.altitude = altitude;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
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
