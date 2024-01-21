package it.unicam.cs.opencity.entity;

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
    private float longitude;
    private float latitude;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "cityId")
    private List<Contest> contests;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "cityId")
    private List<Point> points;

    public City(String cadastralCode, String name, String region, Integer istatCode, float longitude, float latitude) {
        this.cadastralCode = cadastralCode;
        this.name = name;
        this.region = region;
        this.istatCode = istatCode;
        this.longitude = longitude;
        this.latitude = latitude;
        this.points = new ArrayList<>();
        this.contests = new ArrayList<>();
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

    public List<Contest> getContests(){
        return contests;
    }

    public void addContest(Contest contest){
        this.contests.add(contest);
    }

    public void removeContest(Integer id) {
        this.contests.removeIf(c -> c.getId().equals(id));
    }

    public Contest getContest(Integer id){
        for(Contest contest: this.contests) {
            if(contest.getId().equals(id)) return contest;
        }
        return null;
    }

    public List<Point> getPoints(){
        return points;
    }

    public void addPoint(Point point) {
        this.points.add(point);
    }

    public void removePoint(Integer id) {
        this.points.removeIf(p -> p.getId().equals(id));
    }

    public Point getPoint(Integer id) {
        for(Point point: this.points) {
            if(point.getId().equals(id)) return point;
        }
        return null;
    }

    public void addContent(Content content, Integer pointId){
        this.points.get(pointId).addContent(content);
    }

    public void removeContent(Integer contentId, Integer pointId){
        this.points.get(pointId).removeContent(contentId);
    }

    public Content getContent(Integer contentId, Integer pointId){
        return this.getPoint(pointId).getContent(contentId);
    }

}
