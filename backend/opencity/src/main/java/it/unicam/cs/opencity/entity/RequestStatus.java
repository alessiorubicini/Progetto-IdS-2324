package it.unicam.cs.opencity.entity;

public enum RequestStatus {
    PENDING("Pending"),
    ACCEPTED("Accepted"),
    REJECTED("Rejected");

    private final String text;

    RequestStatus(String text) {
        this.text = text;
    }

}
