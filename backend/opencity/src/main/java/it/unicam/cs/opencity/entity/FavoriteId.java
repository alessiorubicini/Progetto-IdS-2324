package it.unicam.cs.opencity.entity;

import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

import java.io.Serializable;

@Embeddable
public class FavoriteId implements Serializable {

    @JoinColumn(name = "userId")
    private Integer userId;

    @JoinColumn(name = "contentId")
    private Integer contentId;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getContent() {
        return contentId;
    }

    public void setContent(Integer contentId) {
        this.contentId = contentId;
    }

}
