package it.unicam.cs.opencity.entity;

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
    @ManyToOne @JoinColumn(name = "cityId")
    private City city;
    @OneToMany(mappedBy = "point", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Content> contents;


}
