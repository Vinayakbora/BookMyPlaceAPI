package com.bajaj.bookmyplace.repository;

import com.bajaj.bookmyplace.models.BookRoom;
import com.bajaj.bookmyplace.models.Location;
import com.bajaj.bookmyplace.models.MeetingRoom;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.List;
import java.util.Optional;

public interface BookRoomRepository extends JpaRepository<BookRoom, Long> {

    public Optional<List<BookRoom>> findBookRoomsBy(String email);
    public Optional<BookRoom> findBookRoomsByDateAndTimeSlot(Date bookingDate, String timeSlot);
}
