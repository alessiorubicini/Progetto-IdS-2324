package it.unicam.cs.opencity.entity;

import jakarta.persistence.*;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Contest")
public class Contest {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String title;
    private String description;
    private Date publicationDate;
    private Date closingDate;
    private Integer authorId;
    @Column(nullable = true)
    private Integer winnerId;
    private Integer cityId;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "contestId")
    private List<Content> contents;

    public Contest(String title, String description, Date publicationDate, Date closingDate, Integer authorId, Integer winnerId, Integer cityId) {
        this.title = title;
        this.description = description;
        this.publicationDate = publicationDate;
        this.closingDate = closingDate;
        this.authorId = authorId;
        this.winnerId = winnerId;
        this.contents = new ArrayList<>();
        this.cityId = cityId;
    }

    public Contest() { }

    public Integer getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getPublicationDate() {
        return publicationDate;
    }

    public void setPublicationDate(Date publicationDate) {
        this.publicationDate = publicationDate;
    }

    public Date getClosingDate() {
        return closingDate;
    }

    public void setClosingDate(Date closingDate) {
        this.closingDate = closingDate;
    }

    public Integer getAuthorId() {
        return authorId;
    }

    public void setAuthorId(Integer authorId) {
        this.authorId = authorId;
    }

    public Integer getWinnerId() {
        return winnerId;
    }

    public void setWinnerId(Integer winnerId) {
        this.winnerId = winnerId;
    }

    public void addContent(Content content){
        this.contents.add(content);
    }

    public void removeContent(Content content) {
        this.contents.remove(content);
    }

    public Integer getCityId() {
        return cityId;
    }

    public void setCityId(Integer cityId) {
        this.cityId = cityId;
    }

    public List<Content> getContents() {
        return contents;
    }

    public void setContents(List<Content> contents) {
        this.contents = contents;
    }
}
