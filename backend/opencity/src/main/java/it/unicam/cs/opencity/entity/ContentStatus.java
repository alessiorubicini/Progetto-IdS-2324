package it.unicam.cs.opencity.entity;

public enum ContentStatus {

    PENDING("Pending"),
    PUBLISHED("Published"),
    REJECTED("Rejected"),
    DRAFT("Draft");

    private final String text;

    ContentStatus(String text) {
        this.text = text;
    }
}
