package it.unicam.cs.opencity.service;

import it.unicam.cs.opencity.entity.City;
import it.unicam.cs.opencity.entity.Contest;
import it.unicam.cs.opencity.entity.Point;
import it.unicam.cs.opencity.repository.CityRepository;
import it.unicam.cs.opencity.repository.ContestRepository;
import it.unicam.cs.opencity.repository.PointRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CityService {

    private final CityRepository cityRepository;
    private final PointRepository pointRepository;
    private final ContestRepository contestRepository;

    @Autowired
    public CityService(CityRepository cityRepository, PointRepository pointRepository, ContestRepository contestRepository) {
        this.cityRepository = cityRepository;
        this.pointRepository = pointRepository;
        this.contestRepository = contestRepository;
    }

    public Iterable<City> getAllCities() {
        return this.cityRepository.findAll();
    }

    public Optional<City> getCityDetails(Integer id) {
        return this.cityRepository.findById(id);
    }

    public List<Contest> getCityContests(Integer id) {
        return contestRepository.findByCityId(id);
    }

    public List<Point> getCityPoints(Integer id) {
        return pointRepository.findByCityId(id);
    }

    public boolean addCity(City city) {
        if(this.cityRepository.existsById(city.getId())) {
            return false;
        } else {
            this.cityRepository.save(city);
            return true;
        }
    }

}
