package com.bajaj.bookmyplace.controllers;

import com.bajaj.bookmyplace.models.*;
import com.bajaj.bookmyplace.services.LocationService;
import com.bajaj.bookmyplace.services.MeetingRoomService;
import com.bajaj.bookmyplace.services.PlayZoneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/playzone")
public class PlayZoneController {

    @Autowired
    PlayZoneService playZoneService;

    @Autowired
    LocationService locationService;


    @PostMapping("")
    public ResponseEntity<Object> createPlayZone(@RequestBody PlayZone playZone){
        PlayZone playZoneNew = playZoneService.createPlayZone(playZone);
        return new ResponseController().generateResponse("PlayZone Created ", HttpStatus.OK,playZoneNew);
    }

    @GetMapping("")
    public ResponseEntity<Object> getAllPLayZones(){
        List<PlayZone> playZones = playZoneService.getAllPlayZones();
        return new ResponseController().generateResponse("PlayZone Fetched ", HttpStatus.OK,playZones);
    }

    @PostMapping("/by-location")
    public ResponseEntity<Object> getPlayZonesByLocation(@RequestBody PlayZoneGetRequest getRequest){
        Location locationToFindPlayZones = locationService.getLocationById(getRequest.getLocationId());
        List<PlayZone> playZones = playZoneService.getPlayZoneByLocation(locationToFindPlayZones.getId());
        return new ResponseController().generateResponse("PlayZone Found ", HttpStatus.OK,playZones);
    }


}
