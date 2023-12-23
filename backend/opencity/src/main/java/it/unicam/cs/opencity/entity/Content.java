package it.unicam.cs.opencity.entity;

import it.unicam.cs.opencity.entity.point.Point;
import jakarta.persistence.*;

import java.sql.Date;
import java.util.List;

public class Content {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id;
    private String title;
    private String description;
    @OneToOne(mappedBy = "Content")
    private User author;
    private Date publicationDate;
    @OneToOne(mappedBy = "Content")
    private Point point;
    private ContentStatus status;
    @OneToMany(mappedBy = "Content")
    private List<Attachment> attachments;

    public Content(Integer id, String title, String description, User author, Date publicationDate, Point point, ContentStatus status, List<Attachment> attachments) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.author = author;
        this.publicationDate = publicationDate;
        this.point = point;
        this.status = status;
        this.attachments = attachments;
    }

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

    public User getAuthor() {
        return author;
    }

    public void setAuthor(User author) {
        this.author = author;
    }

    public Date getPublicationDate() {
        return publicationDate;
    }

    public void setPublicationDate(Date publicationDate) {
        this.publicationDate = publicationDate;
    }

    public Point getPoint() {
        return point;
    }

    public void setPoint(Point point) {
        this.point = point;
    }

    public ContentStatus getStatus() {
        return status;
    }

    public void setStatus(ContentStatus status) {
        this.status = status;
    }

    public List<Attachment> getAttachments() {
        return attachments;
    }

    public void setAttachments(List<Attachment> attachments) {
        this.attachments = attachments;
    }
}
