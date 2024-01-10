package it.unicam.cs.opencity.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "Participation")
public class Participation {

    @EmbeddedId
    private ParticipationId id;


    public ParticipationId getId() {
        return id;
    }
}
