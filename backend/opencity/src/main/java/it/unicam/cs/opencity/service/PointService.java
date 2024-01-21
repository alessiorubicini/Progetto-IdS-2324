package it.unicam.cs.opencity.service;

import it.unicam.cs.opencity.entity.City;
import it.unicam.cs.opencity.entity.Point;
import it.unicam.cs.opencity.repository.CityRepository;
import it.unicam.cs.opencity.repository.PointRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PointService {

    private final CityRepository cityRepository;
    private final PointRepository pointRepository;

    @Autowired
    public PointService(CityRepository cityRepository, PointRepository pointRepository) {
        this.cityRepository = cityRepository;
        this.pointRepository = pointRepository;
    }

    public List<Point> getPointsOfCity(Integer cityId) {
        return this.cityRepository.findById(cityId).get().getPoints();
    }

    public Point getPointDetails(Integer cityId, Integer pointId) {
        City city = cityRepository.findById(cityId).get();
        for(Point point : city.getPoints()) {
            if(point.getId().equals(pointId)) return point;
        }
        return null;
    }

    @Transactional
    public boolean addPoint(Point point, Integer cityId) {
        Optional<City> optionalCity = cityRepository.findById(cityId);
        if(optionalCity.isPresent()) {
            City city = optionalCity.get();
            point.setCityId(cityId);
            city.addPoint(point);
            cityRepository.save(city);
            return true;
        } else {
            return false;
        }
    }

    @Transactional
    public boolean deletePoint(Integer pointId, Integer cityId) {
        pointRepository.deleteById(pointId);
        return true;
        /*Optional<City> optionalCity = cityRepository.findById(cityId);
        if(optionalCity.isPresent()) {
            City city = optionalCity.get();
            city.removePoint(pointId);
            cityRepository.save(city);
            return true;
        } else {
            return false;
        }*/
    }

}
