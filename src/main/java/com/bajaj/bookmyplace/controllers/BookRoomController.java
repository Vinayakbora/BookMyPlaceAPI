package com.bajaj.bookmyplace.controllers;

import com.bajaj.bookmyplace.models.ConferenceBooking;
import com.bajaj.bookmyplace.models.User;
import com.bajaj.bookmyplace.services.ConferenceBookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/bookroom")
public class BookRoomController {

    @Autowired
    ConferenceBookingService conferenceBookingService;


    @PostMapping("")
    public ResponseEntity<Object> bookRoom(@RequestBody ConferenceBooking conferenceBooking){

        ConferenceBooking bookRoomNew = conferenceBookingService.createBookRoom(conferenceBooking);
        return new ResponseController().generateResponse("Booking  Created ", HttpStatus.OK,bookRoomNew);
    }

    @GetMapping("")
    public ResponseEntity<Object> getBookings(){
        List<ConferenceBooking> roomBookings = conferenceBookingService.getAllBookings();
        return new ResponseController().generateResponse("Bookings  Found ", HttpStatus.OK,roomBookings);
    }

    @PostMapping("bookings-by-email")
    public ResponseEntity<Object> getBookingsByUser(@RequestBody User user){
        List<ConferenceBooking> roomBookings = conferenceBookingService.getBookRoomsByUser(user);
        return new ResponseController().generateResponse("Bookings  Found ", HttpStatus.OK,roomBookings);
    }


}
