package it.unicam.cs.opencity.entity.report;

import it.unicam.cs.opencity.entity.User;
import jakarta.persistence.*;

import java.sql.Date;

@Entity
@Table(name = "SystemProblemReport")
public class SystemProblemReport extends Report {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id;
    private String description;
    private Date date;
    @ManyToOne @JoinColumn(name = "userId")
    private User author;
    private String version;
    private String instructions;

    public SystemProblemReport(Integer id, String description, Date date, User author, String version, String instructions) {
        this.id = id;
        this.description = description;
        this.date = date;
        this.author = author;
        this.version = version;
        this.instructions = instructions;
    }

    public SystemProblemReport() { }

    public Integer getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public User getAuthor() {
        return author;
    }

    public void setAuthor(User author) {
        this.author = author;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getInstructions() {
        return instructions;
    }

    public void setInstructions(String instructions) {
        this.instructions = instructions;
    }
}
