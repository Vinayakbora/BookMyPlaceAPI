package com.bajaj.bookmyplace.services;

import com.bajaj.bookmyplace.exceptions.CommonException;
import com.bajaj.bookmyplace.models.CustomUserDetails;
import com.bajaj.bookmyplace.models.Location;
import com.bajaj.bookmyplace.models.MeetingRoom;
import com.bajaj.bookmyplace.repository.MeetingRoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MeetingRoomService {

    @Autowired
    MeetingRoomRepository meetingRoomRepository;

    public MeetingRoom createMeetingRoom(MeetingRoom meetingRoom){
        MeetingRoom meetingRoomNew = meetingRoomRepository.save(meetingRoom);
        return meetingRoomNew;
    }

    public MeetingRoom getMeetingRoomById(Long id){
        Optional<MeetingRoom> meetingRoom =  meetingRoomRepository.findById(id);
        if (meetingRoom.isEmpty()) {
            throw new CommonException("No Room found for provided id ");
        }
        return meetingRoom.get();
    }


    public List<MeetingRoom> getMeetingRoomsByLocation(Long locationId) {
        Location location = new Location();
        location.setId(locationId); // Assuming you have a method to fetch location by ID
        return meetingRoomRepository.findByLocation(location);
    }

    public List<MeetingRoom> getAllMeetingRooms(){


        List<MeetingRoom> meetingRooms =  meetingRoomRepository.findAll();
        if (meetingRooms.isEmpty()){
            throw new CommonException("No Rooms found");
        }
        return meetingRooms;
    }
}
