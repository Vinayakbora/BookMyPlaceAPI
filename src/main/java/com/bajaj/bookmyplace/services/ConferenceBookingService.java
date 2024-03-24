package com.bajaj.bookmyplace.services;

import com.bajaj.bookmyplace.exceptions.CommonException;
import com.bajaj.bookmyplace.models.ConferenceBooking;
import com.bajaj.bookmyplace.models.Location;
import com.bajaj.bookmyplace.models.MeetingRoom;
import com.bajaj.bookmyplace.models.User;
import com.bajaj.bookmyplace.repository.ConferenceBookingRepository;
import com.bajaj.bookmyplace.repository.MeetingRoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class ConferenceBookingService {

    @Autowired
    ConferenceBookingRepository conferenceBookingRepository;

    @Autowired
    MeetingRoomRepository meetingRoomRepository;


    public ConferenceBooking createBookRoom(ConferenceBooking conferenceBooking){

        Optional<ConferenceBooking> bookRoomNew =  conferenceBookingRepository.findBookRoomsByBookingDateAndTimeSlot(conferenceBooking.getBookingDate(), conferenceBooking.getTimeSlot());
        if (bookRoomNew.isEmpty()) {
            ConferenceBooking conferenceBookingCreate = conferenceBookingRepository.save(conferenceBooking);
            return conferenceBookingCreate;
        }
        throw new CommonException("Bookings With same date and timeslot not allowed");

    }

    public List<ConferenceBooking> getBookRoomsByUser(User user){
        Optional<List<ConferenceBooking>> bookRooms =  conferenceBookingRepository.findBookRoomsByUserEmail(user.getEmail());
        if (bookRooms.isEmpty()) {
            throw new CommonException("No Bookings found for provided email ");
        }
        return bookRooms.get();
    }

    public ConferenceBooking getBookRoomByDateAndTimeSlot(String bookingDate, String timeSlot){
        Optional<ConferenceBooking> bookRoom =  conferenceBookingRepository.findBookRoomsByBookingDateAndTimeSlot(bookingDate, timeSlot);
        if (bookRoom.isEmpty()) {
            throw new CommonException("No Booking found for provided timeslot and date ");
        }
        return bookRoom.get();
    }


    public List<ConferenceBooking> getAllBookings(){
        List<ConferenceBooking> bookRoomsOptional =  conferenceBookingRepository.findAll();

        return bookRoomsOptional;
    }


    public List<MeetingRoom> getAllMeetingRoomsByLocation(Location location){
        Optional <List<MeetingRoom>> meetingRoomsOptional =  meetingRoomRepository.findMeetingRoomsByName(location.getName());
        if (meetingRoomsOptional.isEmpty()){
            throw new CommonException("No Room found for provided location ");
        }
        return meetingRoomsOptional.get();
    }
}
