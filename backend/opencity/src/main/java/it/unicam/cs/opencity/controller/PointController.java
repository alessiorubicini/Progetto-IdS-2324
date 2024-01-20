package it.unicam.cs.opencity.controller;

import it.unicam.cs.opencity.entity.Content;
import  it.unicam.cs.opencity.entity.Point;
import it.unicam.cs.opencity.service.ContentService;
import it.unicam.cs.opencity.service.PointService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PointController {

    private final PointService pointService;
    private final ContentService contentService;

    @Autowired
    public PointController(PointService pointService, ContentService contentService) {
        this.pointService = pointService;
        this.contentService = contentService;
    }

    @GetMapping("/city/{id}/points")
    public ResponseEntity<Object> getPointsOfCity(@PathVariable("id") Integer id) {
        return ResponseEntity.ok(pointService.getPointsOfCity(id));
    }

    @GetMapping("/city/{id}/points/{pointId}")
    public ResponseEntity<Object> getPointDetails(@PathVariable("id") Integer id, @PathVariable("pointId") Integer pointId){
        return ResponseEntity.ok(pointService.getPointDetails(id, pointId));
    }

    @PostMapping("/city/{id}/points")
    public ResponseEntity<Point> addPoint(@PathVariable("id") Integer id, @RequestBody Point point) {
        if(pointService.addPoint(point, id)) {
            return new ResponseEntity<>(point, HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/city/{id}/points/{pointId}")
    public ResponseEntity<Object> deletePoint(@PathVariable("id") Integer id, @PathVariable("pointId") Integer pointId) {
        if(pointService.deletePoint(pointId, id)) {
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

}
