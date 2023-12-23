package it.unicam.cs.opencity.entity;

import jakarta.persistence.*;

import java.sql.Date;
import java.util.List;

@Entity
@Table(name = "Contest")
public class Contest {

    @Id @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id;
    private String title;
    private String description;
    private Date publicationDate;
    private Date closingDate;
    @OneToOne @JoinColumn(name = "animatorId")
    private User author;
    @OneToOne @JoinColumn(name = "cityId")
    private City city;
    @OneToOne @JoinColumn(name = "winnerId")
    private User winner;
    @OneToMany(mappedBy = "contest", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Content> contents;
}
