package it.unicam.cs.opencity.controller;

import  it.unicam.cs.opencity.entity.Point;
import it.unicam.cs.opencity.service.PointService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
public class PointController {

    private final PointService pointService;

    @Autowired
    public PointController(PointService pointService) {
        this.pointService = pointService;
    }

    @GetMapping("/city/{cityId}/points")
    public ResponseEntity<Object> getPointsOfCity(@PathVariable Integer cityId) {
        return ResponseEntity.ok(pointService.getPointsOfCity(cityId));
    }

    @GetMapping("/city/{cityId}/points/{pointId}")
    public ResponseEntity<Object> getPointDetails(@PathVariable Integer cityId, @PathVariable Integer pointId){
        return ResponseEntity.ok(pointService.getPointDetails(cityId, pointId));
    }

    @PostMapping("/city/{cityId}/points")
    public ResponseEntity<Point> addPoint(@PathVariable Integer cityId, @RequestBody Point point) {
        if(pointService.addPoint(point, cityId)) {
            return new ResponseEntity<>(point, HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/city/{cityId}/points/{pointId}")
    public ResponseEntity<Object> deletePoint(@PathVariable Integer cityId, @PathVariable Integer pointId) {
        if(pointService.deletePoint(pointId, cityId)) {
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

}
