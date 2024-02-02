package it.unicam.cs.opencity.service;


import it.unicam.cs.opencity.entity.*;
import it.unicam.cs.opencity.repository.CityRepository;
import it.unicam.cs.opencity.repository.ContestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ContestService {

    private final CityRepository cityRepository;
    private final UserService userService;
    private final ContestRepository contestRepository;

    @Autowired
    public ContestService(CityRepository cityRepository, UserService userService, ContestRepository contestRepository) {
        this.cityRepository = cityRepository;
        this.userService = userService;
        this.contestRepository = contestRepository;
    }

    public List<Contest> getContestsOfCity(Integer cityId) {
        Optional<City> city = cityRepository.findById(cityId);
        return city.map(City::getContests).orElse(null);
    }

    public Contest getContestDetails(Integer contestId, Integer cityId) {
        Optional<City> city = cityRepository.findById(cityId);
        return city.map(value -> value.getContest(contestId)).orElse(null);
    }

    public boolean addContest(Contest contest, Integer cityId) {
        Optional<City> city = cityRepository.findById(cityId);
        if (city.isPresent()) {
            city.get().addContest(contest);
            contest.setCityId(cityId);
            cityRepository.save(city.get());
            return true;
        }
        else
            return false;
    }

    public boolean proclaimWinner(Integer cityId, Integer contestId, Integer userId) {
        City city = cityRepository.findById(cityId).get();
        User user = userService.getUserDetails(userId).orElse(null);
        if(user != null){
            city.getContest(contestId).setWinnerId(user.getId());
            cityRepository.save(city);
            return true;
        }
        return false;
    }

    public boolean deleteContest(Integer contestId, Integer cityId) {
        contestRepository.deleteById(contestId);
        return true;
    }

}
