package it.unicam.cs.opencity.entity.point;

import it.unicam.cs.opencity.entity.City;
import it.unicam.cs.opencity.entity.Content;
import jakarta.persistence.Entity;

import java.util.List;

@Entity
public class PhysicalPoint extends Point {

    private float longitude;
    private float latitude;
    private float altitude;

    public PhysicalPoint(Integer id, String name, City city, List<Content> contents, float longitude, float latitude, float altitude) {
        super(id, name, city, contents);
        this.longitude = longitude;
        this.latitude = latitude;
        this.altitude = altitude;
    }

    public PhysicalPoint() { }

    public float getLongitude() {
        return longitude;
    }

    public void setLongitude(float longitude) {
        this.longitude = longitude;
    }

    public float getLatitude() {
        return latitude;
    }

    public void setLatitude(float latitude) {
        this.latitude = latitude;
    }

    public float getAltitude() {
        return altitude;
    }

    public void setAltitude(float altitude) {
        this.altitude = altitude;
    }
}
