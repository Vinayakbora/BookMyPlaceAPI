package com.bajaj.bookmyplace.controllers;

import com.bajaj.bookmyplace.models.Location;
import com.bajaj.bookmyplace.models.TimeSlot;
import com.bajaj.bookmyplace.services.LocationService;
import com.bajaj.bookmyplace.services.TimeSlotService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/timeslot")
public class TimeSlotController {

    @Autowired
    TimeSlotService timeSlotService;


    @PostMapping("")
    public ResponseEntity<Object> createTimeSlot(@RequestBody TimeSlot timeSlot){
        TimeSlot timeSlotNew = timeSlotService.createTimeSlot(timeSlot);
        return new ResponseController().generateResponse("TimeSlot Created ", HttpStatus.OK,timeSlotNew);
    }

    @GetMapping("")
    public ResponseEntity<Object> getTimeSlots(){
        List<TimeSlot> timeSlots = timeSlotService.getAllLocations();
        return new ResponseController().generateResponse("TimeSlots Found ", HttpStatus.OK,timeSlots);
    }
}
