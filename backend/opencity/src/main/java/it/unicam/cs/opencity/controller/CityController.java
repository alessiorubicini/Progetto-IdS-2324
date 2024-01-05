package it.unicam.cs.opencity.controller;

import it.unicam.cs.opencity.entity.City;
import it.unicam.cs.opencity.service.CityService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/city")
public class CityController {

    private final CityService cityService;

    @Autowired
    public CityController(CityService cityService) {
        this.cityService = cityService;
    }

    @GetMapping("/")
    public ResponseEntity<Object> getAllCities() {
        return ResponseEntity.ok(cityService.getAllCities());
    }

    @GetMapping("{id}")
    public ResponseEntity<Object> getCityDetails(@PathVariable("id") Integer id){
        return ResponseEntity.ok(cityService.getCityDetails(id));
    }
    @GetMapping("/{id}/contests")
    public ResponseEntity<Object> getCityContests(@PathVariable("id") String id) {
        return ResponseEntity.ok(cityService.getCityContests(Integer.parseInt(id)));
    }

    @GetMapping("/{id}/points")
    public ResponseEntity<Object> getCityPoints(@PathVariable("id") String id) {
        return ResponseEntity.ok(cityService.getCityPoints(Integer.parseInt(id)));
    }

    @PostMapping("/signup")
    public ResponseEntity<Object> addCity(@RequestBody City city) {
        if(cityService.addCity(city)) {
            return ResponseEntity.ok("City added");
        } else {
            return ResponseEntity.status(409).body("City already exists");
        }
    }

}
