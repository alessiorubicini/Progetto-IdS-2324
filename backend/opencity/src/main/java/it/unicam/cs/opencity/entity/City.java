package it.unicam.cs.opencity.entity;

import it.unicam.cs.opencity.entity.point.Point;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "City")
public class City {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id;
    @Column(unique = true)
    private String cadastralCode;
    private String name;
    private String region;
    private Integer istatCode;
    @OneToMany(mappedBy = "city", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Point> points;

}
