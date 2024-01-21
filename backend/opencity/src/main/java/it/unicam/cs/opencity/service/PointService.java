package it.unicam.cs.opencity.service;

import it.unicam.cs.opencity.entity.City;
import it.unicam.cs.opencity.entity.Point;
import it.unicam.cs.opencity.repository.CityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PointService {

    private final CityRepository cityRepository;

    @Autowired
    public PointService(CityRepository cityRepository) {
        this.cityRepository = cityRepository;
    }

    public List<Point> getPointsOfCity(Integer cityId) {
        return this.cityRepository.findById(cityId).get().getAllPoints();
    }

    public Point getPointDetails(Integer cityId, Integer pointId) {
        City city = cityRepository.findById(cityId).get();
        for(Point point : city.getAllPoints()) {
            if(point.getId().equals(pointId)) return point;
        }
        return null;
    }

    public boolean addPoint(Point point, Integer cityId) {
        Optional<City> optionalCity = cityRepository.findById(cityId);
        if(optionalCity.isPresent()) {
            City city = optionalCity.get();
            city.addPoint(point);
            cityRepository.save(city);
            return true;
        } else {
            return false;
        }
    }

    public boolean deletePoint(Integer pointId, Integer cityId) {
        Optional<City> optionalCity = cityRepository.findById(cityId);
        if(optionalCity.isPresent()) {
            City city = optionalCity.get();
            city.removePoint(pointId);
            cityRepository.save(city);
            return true;
        } else {
            return false;
        }
    }

}
