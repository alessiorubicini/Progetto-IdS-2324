package it.unicam.cs.opencity.entity;

import it.unicam.cs.opencity.entity.point.Point;
import jakarta.persistence.*;

import java.sql.Date;

@Entity
@Table(name = "Content")
public class Content {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String title;
    private String description;
    private Date publicationDate;
    @Enumerated(EnumType.STRING)
    private ContentStatus status;
    @ManyToOne @JoinColumn(name = "authorId")
    private User author;
    @ManyToOne @JoinColumn(name = "pointId")
    private Point point;
    @OneToOne @JoinColumn(name = "mediaId")
    private Media media;
    @ManyToOne @JoinColumn(name = "contestId")
    private Contest contest;

    public Content(Integer id, String title, String description, Date publicationDate, ContentStatus status, User author, Point point, Media media, Contest contest) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.publicationDate = publicationDate;
        this.status = status;
        this.author = author;
        this.point = point;
        this.media = media;
        this.contest = contest;
    }

    public Content() { }

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

    public ContentStatus getStatus() {
        return status;
    }

    public void setStatus(ContentStatus status) {
        this.status = status;
    }

    public User getAuthor() {
        return author;
    }

    public void setAuthor(User author) {
        this.author = author;
    }

    public Point getPoint() {
        return point;
    }

    public void setPoint(Point point) {
        this.point = point;
    }

    public Media getMedia() {
        return media;
    }

    public void setMedia(Media media) {
        this.media = media;
    }

    public Contest getContest() {
        return contest;
    }

    public void setContest(Contest contest) {
        this.contest = contest;
    }
}
