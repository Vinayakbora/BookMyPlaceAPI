package com.bajaj.bookmyplace.repository;

import com.bajaj.bookmyplace.models.PlayZone;
import com.bajaj.bookmyplace.models.PlayZoneBooking;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface PlayZoneBookingRepository extends JpaRepository<PlayZoneBooking, Long> {

    public Optional<List<PlayZoneBooking>> findPLBookRoomsByUserEmail(String userEmail);


    public Optional<PlayZoneBooking> findBookRoomsByBookingDateAndPlayZone(String bookingDate, PlayZone playZone);
}
