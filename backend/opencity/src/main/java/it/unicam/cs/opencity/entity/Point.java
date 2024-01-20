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

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "pointId")
    private ArrayList<Content> contents;

    public Point(String name, String description, Float longitude, Float latitude, Float altitude, String imageUrl) {
        this.name = name;
        this.description = description;
        this.longitude = longitude;
        this.latitude = latitude;
        this.altitude = altitude;
        this.imageUrl = imageUrl;
        this.contents = new ArrayList<>();
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

    public void addContent(Content content){
        this.contents.add(content);
    }

    public void removeContent(Integer id) {
        this.contents.removeIf(c -> c.getId().equals(id));
    }

    public ArrayList<Content> getAllContents(){
        return contents;
    }

    public Content getContent(Integer id){
        return this.contents.get(id);
    }

}
