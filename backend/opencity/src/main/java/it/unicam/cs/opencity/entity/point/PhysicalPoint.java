package it.unicam.cs.opencity.entity.point;

public class PhysicalPoint extends Point {

    private float longitude;
    private float latitude;
    private float altitude;

    public PhysicalPoint(Integer id, String name, float longitude, float latitude, float altitude) {
        super(id, name);
        this.longitude = longitude;
        this.latitude = latitude;
        this.altitude = altitude;
    }

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
