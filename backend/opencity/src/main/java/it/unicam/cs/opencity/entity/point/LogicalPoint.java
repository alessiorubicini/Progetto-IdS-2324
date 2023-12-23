package it.unicam.cs.opencity.entity.point;

public class LogicalPoint extends Point {

    private String topic;

    public LogicalPoint(Integer id, String name, String topic) {
        super(id, name);
        this.topic = topic;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }
}
