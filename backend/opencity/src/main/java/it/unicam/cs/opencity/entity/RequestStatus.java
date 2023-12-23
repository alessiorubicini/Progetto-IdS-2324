package it.unicam.cs.opencity.entity;

public enum RequestStatus {

    PENDING("Pending"),
    ACCEPTED("Accepted"),
    REJECTED("Rejected");

    private final String status;

    RequestStatus(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }
}
