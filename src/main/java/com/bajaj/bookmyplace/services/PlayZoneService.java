package com.bajaj.bookmyplace.services;

import com.bajaj.bookmyplace.exceptions.CommonException;
import com.bajaj.bookmyplace.models.Location;
import com.bajaj.bookmyplace.models.PlayZone;
import com.bajaj.bookmyplace.repository.PLayZoneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PlayZoneService {

    @Autowired
    PLayZoneRepository pLayZoneRepository;

    public PlayZone createPlayZone(PlayZone playZone){
        return pLayZoneRepository.save(playZone);
    }

    public PlayZone getPlayZoneById(Long id){
        Optional<PlayZone> playZone =  pLayZoneRepository.findById(id);
        if (playZone.isEmpty()) {
            throw new CommonException("No PlayZones found for provided id ");
        }
        return playZone.get();
    }


    public List<PlayZone> getPlayZoneByLocation(Long locationId) {
        Location location = new Location();
        location.setId(locationId);
        return pLayZoneRepository.findByLocation(location);
    }

    public List<PlayZone> getAllPlayZones(){


        List<PlayZone> playZones =  pLayZoneRepository.findAll();
        if (playZones.isEmpty()){
            throw new CommonException("No PlayZones found");
        }
        return playZones;
    }
}
