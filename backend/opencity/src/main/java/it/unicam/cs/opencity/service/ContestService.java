package it.unicam.cs.opencity.service;


import it.unicam.cs.opencity.entity.Contest;
import it.unicam.cs.opencity.entity.User;
import it.unicam.cs.opencity.repository.ContestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ContestService {
    private final ContestRepository contestRepository;
    private final UserService userService;

    @Autowired
    public ContestService(ContestRepository contestRepository, UserService userService) {
        this.contestRepository = contestRepository;
        this.userService = userService;
    }

    public boolean suggestContest(Contest contest) {
        contestRepository.save(contest);
        return true;
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

    public Contest getContestDetails(Integer contestId) {
        return contestRepository.findById(contestId).orElse(null);
    }
}
