package com.bajaj.bookmyplace.controllers;

import com.bajaj.bookmyplace.models.Location;
import com.bajaj.bookmyplace.services.LocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/location")

public class LocationController {

    @Autowired
    LocationService locationService;


    @PostMapping("")
    public ResponseEntity<Object> createLocation(@RequestBody  Location location){
        Location locationNew = locationService.createLocation(location);
        return new ResponseController().generateResponse("Location Created ", HttpStatus.OK,locationNew);
    }

    @GetMapping("")
    public ResponseEntity<Object> getLocations(){
        List<Location> locationsNew = locationService.getAllLocations();
        return new ResponseController().generateResponse("Location Found ", HttpStatus.OK,locationsNew);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Object> getLocationById(Long id){
        Location locationNew = locationService.getLocationById(id);
        return new ResponseController().generateResponse("Locations Found ", HttpStatus.OK,locationNew);
    }
}
