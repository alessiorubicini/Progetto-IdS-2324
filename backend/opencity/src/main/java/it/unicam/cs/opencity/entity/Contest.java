package it.unicam.cs.opencity.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.sql.Date;
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
    @OneToOne @JoinColumn(name = "animatorId")
    private User author;
    @ManyToOne @JoinColumn(name = "cityId") @JsonBackReference
    private City city;
    @OneToOne @JoinColumn(name = "winnerId")
    private User winner;
    @OneToMany(mappedBy = "contest", cascade = CascadeType.ALL, orphanRemoval = true) @JsonManagedReference
    private List<Content> contents;

    public Contest(String title, String description, Date publicationDate, Date closingDate, User author, City city, User winner, List<Content> contents) {
        this.title = title;
        this.description = description;
        this.publicationDate = publicationDate;
        this.closingDate = closingDate;
        this.author = author;
        this.city = city;
        this.winner = winner;
        this.contents = contents;
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

    public User getAuthor() {
        return author;
    }

    public void setAuthor(User author) {
        this.author = author;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    public User getWinner() {
        return winner;
    }

    public void setWinner(User winner) {
        this.winner = winner;
    }

    public List<Content> getContents() {
        return contents;
    }

    public void setContents(List<Content> contents) {
        this.contents = contents;
    }
}
