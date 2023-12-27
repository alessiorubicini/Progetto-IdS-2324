package it.unicam.cs.opencity.entity.report;

import it.unicam.cs.opencity.entity.User;
import jakarta.persistence.*;

import java.sql.Date;

@Entity
//@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class Report {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String description;
    private Date date;
    @ManyToOne @JoinColumn(name = "userId")
    private User author;

    // TODO: da finire

}
