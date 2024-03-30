package com.bajaj.bookmyplace.repository;

import com.bajaj.bookmyplace.models.Location;
import com.bajaj.bookmyplace.models.MeetingRoom;
import com.bajaj.bookmyplace.models.PlayZone;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PLayZoneRepository extends JpaRepository<PlayZone, Long> {

   List<PlayZone> findByLocation(Location location);
}
