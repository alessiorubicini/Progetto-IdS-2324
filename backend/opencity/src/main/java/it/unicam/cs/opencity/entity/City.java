package it.unicam.cs.opencity.entity;

import jakarta.persistence.*;

import java.util.ArrayList;

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

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "cityId")
    private ArrayList<Contest> contests;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "cityId")
    private ArrayList<Point> points;

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

    public ArrayList<Contest> getAllContest(){
        return contests;
    }
    public void addContest(Contest contest){
        this.contests.add(contest);
    }
    public void removeContest(Contest contest) {
        this.contests.remove(contest);
    }
    public Contest getContest(Integer id){
        return this.contests.get(id);
    }
    public ArrayList<Point> getAllPoints(){
        return points;
    }
    public void addPoint(Point point){
        this.points.add(point);
    }
    public void removePoint(Point point){this.points.remove(point);}
    public Point getPoint(Integer id){return this.points.get(id);}
    public void addContent(Content content, Integer idPunto){
        this.points.get(idPunto).addContent(content);
    }
    public void removeContent(Content content, Integer idPunto){
        this.points.get(idPunto).removeContent(content);
    }
    public Content getContent(Integer content, Integer idPunto){
        return this.points.get(idPunto).getContent(content);
    }

}
