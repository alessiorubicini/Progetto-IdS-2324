package it.unicam.cs.opencity.controller;

import it.unicam.cs.opencity.entity.Contest;
import it.unicam.cs.opencity.service.ContestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/contest")
public class ContestController {

    private final ContestService contestService;

    @Autowired
    public ContestController(ContestService contestService) {
        this.contestService = contestService;
    }

    @PostMapping("/")
    public ResponseEntity<Object> addContest(@RequestBody Contest contest) {
        if (contestService.suggestContest(contest))
            return new ResponseEntity<>(contest, HttpStatus.OK);
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);

    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> proclaimWinner(@PathVariable("id") Integer id, @RequestParam Integer userId){
        if(contestService.proclaimWinner(id, userId))
            return new ResponseEntity<>(HttpStatus.OK);
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }


    @GetMapping("/{id}")
    public ResponseEntity<Object> getContestDetail(@PathVariable Integer id) {
        Contest contest = contestService.getContestDetails(id);
        if(contest != null)
            return new ResponseEntity<>(contest, HttpStatus.OK);
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    
}
