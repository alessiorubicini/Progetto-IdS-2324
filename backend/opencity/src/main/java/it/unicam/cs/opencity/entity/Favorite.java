package it.unicam.cs.opencity.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "Favorite")
public class Favorite {

    @EmbeddedId
    private FavoriteId id;

    public void setId(FavoriteId id) {
        this.id = id;
    }

}
