package com.bajaj.bookmyplace.services;

import com.bajaj.bookmyplace.exceptions.CommonException;
import com.bajaj.bookmyplace.models.BookRoom;
import com.bajaj.bookmyplace.models.Location;
import com.bajaj.bookmyplace.models.MeetingRoom;
import com.bajaj.bookmyplace.repository.BookRoomRepository;
import com.bajaj.bookmyplace.repository.MeetingRoomRepository;
import com.bajaj.bookmyplace.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class BookRoomService {

    @Autowired
    BookRoomRepository bookRoomRepository;

    @Autowired
    MeetingRoomRepository meetingRoomRepository;


    public BookRoom createBookRoom(BookRoom bookRoom){

        Optional<BookRoom> bookRoomNew =  bookRoomRepository.findBookRoomsByDateAndTimeSlot(bookRoom.getBookingDate(), bookRoom.getTimeSlot());
        if (bookRoomNew.isEmpty()) {
            BookRoom bookRoomCreate = bookRoomRepository.save(bookRoom);
            return bookRoomCreate;
        }
        throw new CommonException("Bookings With same date and timeslot not allowed");

    }

    public List<BookRoom> getBookRoomsByUserEmail(String email){
        Optional<List<BookRoom>> bookRooms =  bookRoomRepository.findBookRoomsBy(email);
        if (bookRooms.isEmpty()) {
            throw new CommonException("No Bookings found for provided email ");
        }
        return bookRooms.get();
    }

    public BookRoom getBookRoomByDateAndTimeSlot(Date bookingDate, String timeSlot){
        Optional<BookRoom> bookRoom =  bookRoomRepository.findBookRoomsByDateAndTimeSlot(bookingDate, timeSlot);
        if (bookRoom.isEmpty()) {
            throw new CommonException("No Booking found for provided timeslot and date ");
        }
        return bookRoom.get();
    }


    public List<MeetingRoom> getAllMeetingRoomsByLocation(Location location){
        Optional <List<MeetingRoom>> meetingRoomsOptional =  meetingRoomRepository.findMeetingRoomsBy(location);
        if (meetingRoomsOptional.isEmpty()){
            throw new CommonException("No Room found for provided location ");
        }
        return meetingRoomsOptional.get();
    }
}