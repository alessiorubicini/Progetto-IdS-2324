package it.unicam.cs.opencity.entity;

import jakarta.persistence.Table;

@Table(name = "RequestStatus")
public enum RequestStatus {

    PENDING("Pending"),
    ACCEPTED("Accepted"),
    REJECTED("Rejected");

    private final String status;

    RequestStatus(String status) {
        this.status = status;
    }

}
