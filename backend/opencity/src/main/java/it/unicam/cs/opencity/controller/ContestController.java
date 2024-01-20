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

    @GetMapping("/city/{id}/contests")
    public ResponseEntity<Object> getContestsOfCity(@PathVariable Integer id) {
        return ResponseEntity.ok(contestService.getContestsOfCity(id));
    }

    @GetMapping("/city/{id}/contests/{contestId}")
    public ResponseEntity<Object> getContestDetail(@PathVariable Integer id, @PathVariable Integer contestId) {
        Contest contest = contestService.getContestDetails(contestId, id);
        if(contest != null) {
            return new ResponseEntity<>(contest, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/city/{id}/contests")
    public ResponseEntity<Object> addContest(@RequestBody Contest contest, @PathVariable Integer id) {
        if (contestService.addContest(contest, id)) {
            return new ResponseEntity<>(contest, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/city/{id}/contests/{contestId}")
    public ResponseEntity<Object> deleteContest(@PathVariable Integer id, @PathVariable Integer contestId){
        if(this.contestService.deleteContest(contestId, id))
            return new ResponseEntity<>(HttpStatus.OK);
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PutMapping("/city/{id}/contests/{contestId}/proclaimWinner")
    public ResponseEntity<Object> proclaimWinner(@PathVariable("id") Integer id, @RequestParam Integer userId){
        if(contestService.proclaimWinner(id, userId))
            return new ResponseEntity<>(HttpStatus.OK);
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

}
