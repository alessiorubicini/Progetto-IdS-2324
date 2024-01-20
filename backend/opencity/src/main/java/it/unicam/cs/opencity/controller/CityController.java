package it.unicam.cs.opencity.controller;

import it.unicam.cs.opencity.service.CityService;
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

    @GetMapping("/{id}")
    public ResponseEntity<Object> getCityDetails(@PathVariable("id") Integer id){
        return ResponseEntity.ok(cityService.getCityDetails(id));
    }

}
