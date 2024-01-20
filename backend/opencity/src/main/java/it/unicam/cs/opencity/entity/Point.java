package it.unicam.cs.opencity.entity;

import jakarta.persistence.*;

import java.util.ArrayList;

@Entity
@Table(name = "Point")
public class Point {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String description;
    @Column(nullable = true)
    private Float longitude;
    @Column(nullable = true)
    private Float latitude;
    @Column(nullable = true)
    private Float altitude;
    private String imageUrl;
    private Integer cityId;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "pointId")
    private ArrayList<Content> contenuti;


    public Point(String name, String description, Float longitude, Float latitude, Float altitude, String imageUrl, Integer cityId) {
        this.name = name;
        this.description = description;
        this.longitude = longitude;
        this.latitude = latitude;
        this.altitude = altitude;
        this.imageUrl = imageUrl;
        this.cityId = cityId;
        this.contenuti = new ArrayList<>();
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

    public Float getLongitude() {
        return longitude;
    }

    public void setLongitude(Float longitude) {
        this.longitude = longitude;
    }

    public Float getLatitude() {
        return latitude;
    }

    public void setLatitude(Float latitude) {
        this.latitude = latitude;
    }

    public Float getAltitude() {
        return altitude;
    }

    public void setAltitude(Float altitude) {
        this.altitude = altitude;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public Integer getCityId() {
        return cityId;
    }

    public void setCityId(Integer cityId) {
        this.cityId = cityId;
    }

    public void addContent(Content content){
        this.contenuti.add(content);
    }

    public void removeContent(Content content) {
        this.contenuti.remove(content);
    }

    public ArrayList<Content> getAllContent(){
        return contenuti;
    }

    public Content getContent(Integer id){
        return this.contenuti.get(id);
    }

}
