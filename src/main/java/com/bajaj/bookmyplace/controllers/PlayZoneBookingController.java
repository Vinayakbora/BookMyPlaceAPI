package com.bajaj.bookmyplace.controllers;

import com.bajaj.bookmyplace.models.PlayZoneBooking;
import com.bajaj.bookmyplace.models.User;
import com.bajaj.bookmyplace.services.PlayZoneBookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/v1/pz_book_room")
public class PlayZoneBookingController {

    @Autowired
    PlayZoneBookingService playZoneBookingService;


    @PostMapping("")
    public ResponseEntity<Object> bookRoom(@RequestBody PlayZoneBooking playZoneBooking){

        PlayZoneBooking bookRoomPz = playZoneBookingService.createBookRoom(playZoneBooking);
        return new ResponseController().generateResponse("Booking  Created ", HttpStatus.OK,bookRoomPz);
    }

    @GetMapping("")
    public ResponseEntity<Object> getBookings(){
        List<PlayZoneBooking> roomBookings = playZoneBookingService.getAllBookings();
        return new ResponseController().generateResponse("Bookings  Found ", HttpStatus.OK,roomBookings);
    }

    @PostMapping("bookings-by-email")
    public ResponseEntity<Object> getBookingsByUser(@RequestBody User user){
        List<PlayZoneBooking> roomBookings = playZoneBookingService.getBookRoomsByUser(user);
        return new ResponseController().generateResponse("Bookings  Found ", HttpStatus.OK,roomBookings);
    }


}
