package it.unicam.cs.opencity.service;


import it.unicam.cs.opencity.entity.*;
import it.unicam.cs.opencity.repository.CityRepository;
import it.unicam.cs.opencity.repository.ContestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContestService {

    private final ContestRepository contestRepository;
    private final CityRepository cityRepository;
    private final UserService userService;

    @Autowired
    public ContestService(ContestRepository contestRepository, CityRepository cityRepository, UserService userService) {
        this.contestRepository = contestRepository;
        this.cityRepository = cityRepository;
        this.userService = userService;
    }

    public List<Contest> getContestsOfCity(Integer cityId) {
        if (cityRepository.findById(cityId).isPresent()) {
            City city = cityRepository.findById(cityId).get();
            return city.getContests();
        } else {
            return null;
        }
    }

    public Contest getContestDetails(Integer contestId, Integer cityId) {
        if (cityRepository.findById(cityId).isPresent()) {
            City city = cityRepository.findById(cityId).get();
            return city.getContest(contestId);
        } else {
            return null;
        }
    }

    public boolean addContest(Contest contest, Integer cityId) {
        if (cityRepository.findById(cityId).isPresent()) {
            City city = cityRepository.findById(cityId).get();
            city.addContest(contest);
            contest.setCityId(cityId);
            cityRepository.save(city);
            return true;
        } else {
            return false;
        }
    }

    public boolean proclaimWinner(Integer contestId, Integer userId) {
        Contest contest = contestRepository.findById(contestId).orElse(null);
        User user = userService.getUserDetails(userId).orElse(null);
        if(contest != null && user != null){
            contest.setWinnerId(user.getId());
            contestRepository.save(contest);
            return true;
        }
        return false;
    }

    public boolean deleteContest(Integer contestId, Integer cityId) {
        contestRepository.deleteById(contestId);
        return true;
        /*if (cityRepository.findById(cityId).isPresent()) {
            City city = cityRepository.findById(cityId).get();
            city.removeContest(contestId);
            cityRepository.save(city);
            return true;
        } else {
            return false;
        }*/
    }

}
