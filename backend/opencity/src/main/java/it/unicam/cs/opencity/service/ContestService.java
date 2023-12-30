package it.unicam.cs.opencity.service;


import it.unicam.cs.opencity.entity.Contest;
import it.unicam.cs.opencity.repository.ContestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ContestService {
    private final ContestRepository contestRepository;

    @Autowired
    public ContestService(ContestRepository contestRepository) {
        this.contestRepository = contestRepository;
    }

    public boolean suggestContest(Contest contest) {
        contestRepository.save(contest);
        return true;
    }

    public boolean proclaimWinner(Integer contestId, Integer userId) {
        Contest contest = contestRepository.findById(contestId).orElse(null);
        if(contest != null){
            contest.setWinner(new UserService().getUserDetails(userId).orElse(null));
            contestRepository.save(contest);
        }
        return true;
    }
    public Contest getContestDetails(Integer contestId) {
        return contestRepository.findById(contestId).orElse(null);
    }

}
