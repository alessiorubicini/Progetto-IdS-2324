package it.unicam.cs.opencity.entity.point;

import it.unicam.cs.opencity.entity.City;
import it.unicam.cs.opencity.entity.Content;
import jakarta.persistence.Entity;

import java.util.List;

@Entity
public class LogicalPoint extends Point {

    private String topic;

    public LogicalPoint(Integer id, String name, City city, List<Content> contents, String topic) {
        super(id, name, city, contents);
        this.topic = topic;
    }

    public LogicalPoint() { }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }
}
