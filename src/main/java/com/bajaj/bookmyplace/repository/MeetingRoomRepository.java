package com.bajaj.bookmyplace.repository;

import com.bajaj.bookmyplace.models.Location;
import com.bajaj.bookmyplace.models.MeetingRoom;
import com.bajaj.bookmyplace.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface MeetingRoomRepository extends JpaRepository<MeetingRoom, Long> {

   List<MeetingRoom> findByLocation(Location location);
}
