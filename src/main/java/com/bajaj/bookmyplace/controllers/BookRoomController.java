package com.bajaj.bookmyplace.controllers;

import com.bajaj.bookmyplace.models.BookRoom;
import com.bajaj.bookmyplace.models.Location;
import com.bajaj.bookmyplace.models.MeetingRoom;
import com.bajaj.bookmyplace.models.User;
import com.bajaj.bookmyplace.services.BookRoomService;
import com.bajaj.bookmyplace.services.MeetingRoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/bookroom")
public class BookRoomController {

    @Autowired
    BookRoomService bookRoomService;


    @PostMapping("")
    public ResponseEntity<Object> bookRoom(@RequestBody BookRoom bookRoom){

        BookRoom bookRoomNew = bookRoomService.createBookRoom(bookRoom);
        return new ResponseController().generateResponse("Booking  Created ", HttpStatus.OK,bookRoomNew);
    }

    @GetMapping("")
    public ResponseEntity<Object> getBookings(){
        List<BookRoom> roomBookings = bookRoomService.getAllBookings();
        return new ResponseController().generateResponse("Bookings  Found ", HttpStatus.OK,roomBookings);
    }

    @PostMapping("bookings-by-email")
    public ResponseEntity<Object> getBookingsByUser(@RequestBody User user){
        List<BookRoom> roomBookings = bookRoomService.getBookRoomsByUser(user);
        return new ResponseController().generateResponse("Bookings  Found ", HttpStatus.OK,roomBookings);
    }


}
