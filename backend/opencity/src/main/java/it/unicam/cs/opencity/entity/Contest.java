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
    private Integer cityId;
    @Column(nullable = true)
    private Integer winnerId;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "contestId")
    private ArrayList<Content> contenuti;

    public Contest(String title, String description, Date publicationDate, Date closingDate, Integer authorId, Integer cityId, Integer winnerId) {
        this.title = title;
        this.description = description;
        this.publicationDate = publicationDate;
        this.closingDate = closingDate;
        this.authorId = authorId;
        this.cityId = cityId;
        this.winnerId = winnerId;
        this.contenuti = new ArrayList<>();
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

    public Integer getCityId() {
        return cityId;
    }

    public void setCityId(Integer cityId) {
        this.cityId = cityId;
    }

    public Integer getWinnerId() {
        return winnerId;
    }

    public void setWinnerId(Integer winnerId) {
        this.winnerId = winnerId;
    }

    public void addContent(Content content){
        this.contenuti.add(content);
    }

    public void removeContent(Content content) {
        this.contenuti.remove(content);
    }

}
