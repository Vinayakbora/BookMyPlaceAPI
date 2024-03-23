package com.bajaj.bookmyplace.services;

import com.bajaj.bookmyplace.models.Location;
import com.bajaj.bookmyplace.repository.LocationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LocationService {

    @Autowired
    LocationRepository locationRepository;

    public Location createLocation(Location location){
       Location locationNew = locationRepository.save(location);
       return locationNew;
    }

    public Location getLocationById(Long id){
      Optional<Location> location =  locationRepository.findById(id);
      return location.get();
    }

    public List<Location> getAllLocations(){
        List<Location> locations =  locationRepository.findAll();
        return locations;
    }
}
