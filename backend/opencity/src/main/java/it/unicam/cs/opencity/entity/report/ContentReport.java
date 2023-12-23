package it.unicam.cs.opencity.entity.report;

import it.unicam.cs.opencity.entity.Content;
import it.unicam.cs.opencity.entity.User;
import jakarta.persistence.*;

import java.sql.Date;

@Entity
@Table(name = "ContentReport")
public class ContentReport extends Report {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id;
    private String description;
    private Date date;
    @ManyToOne @JoinColumn(name = "userId")
    private User author;
    @ManyToOne @JoinColumn(name = "contentId")
    private Content content;

    public ContentReport(Integer id, String description, Date date, User author, Content content) {
        this.id = id;
        this.description = description;
        this.date = date;
        this.author = author;
        this.content = content;
    }

    public ContentReport() { }

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

    public Content getContent() {
        return content;
    }

    public void setContent(Content content) {
        this.content = content;
    }
}
