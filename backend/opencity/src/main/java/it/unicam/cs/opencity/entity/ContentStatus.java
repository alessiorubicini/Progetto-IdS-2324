package it.unicam.cs.opencity.entity;

public enum ContentStatus {

    Pending("Pending"),
    Published("Published"),
    Rejected("Rejected"),
    Draft("Draft");

    private final String status;

    ContentStatus(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }
}
