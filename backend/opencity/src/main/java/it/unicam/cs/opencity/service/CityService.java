package it.unicam.cs.opencity.service;

import it.unicam.cs.opencity.entity.City;
import it.unicam.cs.opencity.entity.Content;
import it.unicam.cs.opencity.entity.Contest;
import it.unicam.cs.opencity.entity.Point;
import it.unicam.cs.opencity.repository.CityRepository;
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

    public List<Content> getCityContents(Integer id) {
        Optional<City> city = this.cityRepository.findById(id);
        return city.map(City::getAllContents).orElse(null);
    }

    public List<Contest> getCityContests(Integer id) {
        Optional<City> city = this.cityRepository.findById(id);
        return city.map(City::getContests).orElse(null);
    }

    public List<Point> getCityPoints(Integer id) {
        Optional<City> city = this.cityRepository.findById(id);
        return city.map(City::getPoints).orElse(null);
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
