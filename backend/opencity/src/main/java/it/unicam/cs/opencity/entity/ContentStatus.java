package it.unicam.cs.opencity.entity;

public enum ContentStatus {

    PENDING("Pending"),
    PUBLISHED("Published"),
    REJECTED("Rejected"),
    DRAFT("Draft");

    private final String status;

    ContentStatus(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }
}
