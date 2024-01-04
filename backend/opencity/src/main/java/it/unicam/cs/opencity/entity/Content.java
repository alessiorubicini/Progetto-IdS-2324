package it.unicam.cs.opencity.entity;

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
    private Integer authorId;
    private Integer pointId;
    private String mediaUrl;
    private Integer contestId;

    public Content(String title, String description, Date publicationDate, ContentStatus status, Integer authorId, Integer pointId, String mediaUrl, Integer contestId) {
        this.title = title;
        this.description = description;
        this.publicationDate = publicationDate;
        this.status = status;
        this.authorId = authorId;
        this.pointId = pointId;
        this.mediaUrl = mediaUrl;
        this.contestId = contestId;
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

    public Integer getAuthorId() {
        return authorId;
    }

    public void setAuthorId(Integer authorId) {
        this.authorId = authorId;
    }

    public Integer getPointId() {
        return pointId;
    }

    public void setPointId(Integer pointId) {
        this.pointId = pointId;
    }

    public String getMediaUrl() {
        return mediaUrl;
    }

    public void setMediaUrl(String mediaUrl) {
        this.mediaUrl = mediaUrl;
    }

    public Integer getContestId() {
        return contestId;
    }

    public void setContestId(Integer contestId) {
        this.contestId = contestId;
    }
}
