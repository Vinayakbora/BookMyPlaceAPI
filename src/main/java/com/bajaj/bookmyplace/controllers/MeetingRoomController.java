package com.bajaj.bookmyplace.controllers;

import com.bajaj.bookmyplace.models.Location;
import com.bajaj.bookmyplace.models.MeetingRoom;
import com.bajaj.bookmyplace.models.MeetingRoomGetRequest;
import com.bajaj.bookmyplace.services.LocationService;
import com.bajaj.bookmyplace.services.MeetingRoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/meetingroom")
public class MeetingRoomController {

    @Autowired
    MeetingRoomService meetingRoomService;

    @Autowired
    LocationService locationService;


    @PostMapping("")
    public ResponseEntity<Object> createMeetingRoom(@RequestBody MeetingRoom meetingRoom){
        MeetingRoom meetingRoomNew = meetingRoomService.createMeetingRoom(meetingRoom);
        return new ResponseController().generateResponse("Meeting Room Created ", HttpStatus.OK,meetingRoomNew);
    }

    @GetMapping("")
    public ResponseEntity<Object> getAllMeetingRooms(){
        List<MeetingRoom> meetingRooms = meetingRoomService.getAllMeetingRooms();
        return new ResponseController().generateResponse("Meeting Room Created ", HttpStatus.OK,meetingRooms);
    }

    @PostMapping("/by-location")
    public ResponseEntity<Object> getMeetingRoomsByLocation(@RequestBody MeetingRoomGetRequest getRequest){
        Location locationToFindMeetingRooms = locationService.getLocationById(getRequest.getLocationId());
        List<MeetingRoom> meetingRooms = meetingRoomService.getMeetingRoomsByLocation(locationToFindMeetingRooms.getId());
        return new ResponseController().generateResponse("Meeting Room Found ", HttpStatus.OK,meetingRooms);
    }


}
