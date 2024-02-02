package it.unicam.cs.opencity.controller;

import it.unicam.cs.opencity.entity.Contest;
import it.unicam.cs.opencity.service.ContestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class ContestController {

    private final ContestService contestService;

    @Autowired
    public ContestController(ContestService contestService) {
        this.contestService = contestService;
    }

    @GetMapping("/city/{cityId}/contests")
    public ResponseEntity<Object> getContestsOfCity(@PathVariable Integer cityId) {
        return ResponseEntity.ok(contestService.getContestsOfCity(cityId));
    }

    @GetMapping("/city/{cityId}/contests/{contestId}")
    public ResponseEntity<Object> getContestDetail(@PathVariable Integer cityId, @PathVariable Integer contestId) {
        Contest contest = contestService.getContestDetails(contestId, cityId);
        if(contest != null) {
            return new ResponseEntity<>(contest, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/city/{cityId}/contests")
    public ResponseEntity<Object> addContest(@RequestBody Contest contest, @PathVariable Integer cityId) {
        if (contestService.addContest(contest, cityId)) {
            return new ResponseEntity<>(contest, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/city/{cityId}/contests/{contestId}")
    public ResponseEntity<Object> deleteContest(@PathVariable Integer cityId, @PathVariable Integer contestId){
        if(this.contestService.deleteContest(contestId, cityId))
            return new ResponseEntity<>(HttpStatus.OK);
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PutMapping("/city/{cityId}/contests/{contestId}/proclaimWinner")
    public ResponseEntity<Object> proclaimWinner(@PathVariable Integer cityId, @PathVariable Integer contestId, @RequestParam Integer userId){
        if(contestService.proclaimWinner(cityId, contestId, userId))
            return new ResponseEntity<>(HttpStatus.OK);
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

}
