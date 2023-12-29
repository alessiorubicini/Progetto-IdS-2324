package it.unicam.cs.opencity.entity;

public enum RequestStatus {

    Pending("Pending"),
    Accepted("Accepted"),
    Rejected("Rejected");

    private final String status;

    RequestStatus(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }
}
