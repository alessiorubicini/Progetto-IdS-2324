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
    @Autowired
    public CityService(CityRepository cityRepository) {
        this.cityRepository = cityRepository;
    }

    public Iterable<City> getAllCities() {
        return this.cityRepository.findAll();
    }

    public Optional<City> getCityDetails(Integer id) {
        return this.cityRepository.findById(id);
    }

}
