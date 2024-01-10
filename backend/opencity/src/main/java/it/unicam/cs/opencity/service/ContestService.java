package it.unicam.cs.opencity.service;


import it.unicam.cs.opencity.entity.Content;
import it.unicam.cs.opencity.entity.Contest;
import it.unicam.cs.opencity.entity.User;
import it.unicam.cs.opencity.repository.ContentRepository;
import it.unicam.cs.opencity.repository.ContestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class ContestService {
    private final ContestRepository contestRepository;
    private final UserService userService;
    private final ContentRepository contentRepository;

    @Autowired
    public ContestService(ContestRepository contestRepository, UserService userService, ContentRepository contentRepository) {
        this.contestRepository = contestRepository;
        this.userService = userService;
        this.contentRepository = contentRepository;
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

    public boolean deleteContest(Integer contestId){
        try{
            contestRepository.delete(contestRepository.findById(contestId).get());
            return true;
        }
        catch(NoSuchElementException e) {
            return false;
        }
    }

    public List<Content> getProposedContents(Integer contestId)
    {
        return contentRepository.findByContestId(contestId);
    }
    public Contest getContestDetails(Integer contestId) {
        return contestRepository.findById(contestId).orElse(null);
    }
}
