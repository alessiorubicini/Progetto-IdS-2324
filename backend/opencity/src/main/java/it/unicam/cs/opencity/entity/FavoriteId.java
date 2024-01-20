package it.unicam.cs.opencity.entity;

import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

import java.io.Serializable;

@Embeddable
public class FavoriteId implements Serializable {

    @JoinColumn(name = "userId")
    private Integer userId;

    @ManyToOne
    @JoinColumn(name = "contentId")
    private Content content;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Content getContent() {
        return content;
    }

    public void setContent(Content content) {
        this.content = content;
    }

}
