package it.unicam.cs.opencity.entity;

import jakarta.persistence.Table;

@Table(name = "ContentStatus")
public enum ContentStatus {

    PENDING("Pending"),
    PUBLISHED("Published"),
    REJECTED("Rejected"),
    DRAFT("Draft");

    private final String status;

    ContentStatus(String status) {
        this.status = status;
    }
}
