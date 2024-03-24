package com.bajaj.bookmyplace.services;

import com.bajaj.bookmyplace.models.Location;
import com.bajaj.bookmyplace.models.TimeSlot;
import com.bajaj.bookmyplace.repository.LocationRepository;
import com.bajaj.bookmyplace.repository.TimeSlotRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Time;
import java.util.List;
import java.util.Optional;

@Service
public class TimeSlotService {

    @Autowired
    TimeSlotRepository timeSlotRepository;

    public TimeSlot createTimeSlot(TimeSlot timeSlot){
        TimeSlot timeSlotNew = timeSlotRepository.save(timeSlot);
        return timeSlotNew;
    }


    public List<TimeSlot> getAllLocations(){
        List<TimeSlot> timeSlots =  timeSlotRepository.findAll();
        return timeSlots;
    }
}
