package it.unicam.cs.opencity.controller;

import  it.unicam.cs.opencity.entity.Point;
import it.unicam.cs.opencity.service.PointService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/point")
public class PointController {
    private final PointService pointService;

    @Autowired
    public PointController(PointService pointService) {
        this.pointService = pointService;
    }

    @PostMapping("/add")
    public ResponseEntity<Point> addPoint(@RequestBody Point point) {
        if(pointService.addPoint(point))
            return new ResponseEntity<>(point, HttpStatus.CREATED);
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> removePoint(@PathVariable("id") Integer id) {
        if(pointService.removePoint(id))
            return new ResponseEntity<>(HttpStatus.OK);
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getPointDetails(@PathVariable("id") Integer id){
        Optional<Point> point = pointService.getPointDetails(id);
        if(point.isPresent())
            return new ResponseEntity<>(point, HttpStatus.OK);
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

}
