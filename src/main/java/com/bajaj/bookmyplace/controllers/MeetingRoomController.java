package com.bajaj.bookmyplace.controllers;

import com.bajaj.bookmyplace.models.Location;
import com.bajaj.bookmyplace.models.MeetingRoom;
import com.bajaj.bookmyplace.services.LocationService;
import com.bajaj.bookmyplace.services.MeetingRoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/meetingroom")
public class MeetingRoomController {

    @Autowired
    MeetingRoomService meetingRoomService;


    @PostMapping("")
    public ResponseEntity<Object> createMeetingRoom(@RequestBody MeetingRoom meetingRoom){
        MeetingRoom meetingRoomNew = meetingRoomService.createMeetingRoom(meetingRoom);
        return new ResponseController().generateResponse("Meeting Room Created ", HttpStatus.OK,meetingRoomNew);
    }

    @PostMapping("/by-location")
    public ResponseEntity<Object> getMeetingRoomsByLocation(@RequestBody Location location){
        List<MeetingRoom> meetingRooms = meetingRoomService.getAllMeetingRoomsByLocation(location);
        return new ResponseController().generateResponse("Meeting Room Found ", HttpStatus.OK,meetingRooms);
    }


}
