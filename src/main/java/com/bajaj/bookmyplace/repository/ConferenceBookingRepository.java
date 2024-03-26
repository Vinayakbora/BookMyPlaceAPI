package com.bajaj.bookmyplace.repository;

import com.bajaj.bookmyplace.models.ConferenceBooking;
import com.bajaj.bookmyplace.models.MeetingRoom;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.List;
import java.util.Optional;

public interface ConferenceBookingRepository extends JpaRepository<ConferenceBooking, Long> {

    public Optional<List<ConferenceBooking>> findBookRoomsByUserEmail(String userEmail);
    public Optional<ConferenceBooking> findBookRoomsByBookingDateAndMeetingRoom(String bookingDate, MeetingRoom meetingRoom);
}
