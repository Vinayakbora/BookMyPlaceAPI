package com.bajaj.bookmyplace.services;

import com.bajaj.bookmyplace.exceptions.CommonException;
import com.bajaj.bookmyplace.models.PlayZoneBooking;
import com.bajaj.bookmyplace.models.User;
import com.bajaj.bookmyplace.repository.PlayZoneBookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class PlayZoneBookingService {

    @Autowired
    PlayZoneBookingRepository playZoneBookingRepository;


    public PlayZoneBooking createBookRoom(PlayZoneBooking playZoneBookingNew) {


        Optional<PlayZoneBooking> PlayZoneBookingExisting = playZoneBookingRepository.findBookRoomsByBookingDateAndPlayZone(playZoneBookingNew.getBookingDate(), playZoneBookingNew.getPLayZone());

        if (PlayZoneBookingExisting.isEmpty()) {

            return playZoneBookingRepository.save(playZoneBookingNew);


        } else {
            PlayZoneBooking playZoneBookingExisting1 = PlayZoneBookingExisting.get();
            Boolean isTimeSlotAvailable = isTimeSlotAvailable(playZoneBookingExisting1, playZoneBookingNew);
            if (isTimeSlotAvailable) {
                return playZoneBookingRepository.save(playZoneBookingNew);
            }
            throw new CommonException("Booking slot not available");
        }


    }

    private Boolean isTimeSlotAvailable(PlayZoneBooking bookingExisting, PlayZoneBooking newBooking) {
        String existingBookingStartTime = bookingExisting.getStartTime();
        String existingBookingEndTime = bookingExisting.getEndTime();

        String newBookingStartTime = newBooking.getStartTime();
        String newBookingEndTime = newBooking.getEndTime();
        if (existingBookingStartTime.equals(newBookingStartTime)) {
            return false;
        } else {
            SimpleDateFormat parser = new SimpleDateFormat("HH:mm");
            Date startTimeExisting;
            Date endTimeExisting;

            Date startTimeNew;
            Date endTimeNew;
            try {
                startTimeExisting = parser.parse(existingBookingStartTime);
                endTimeExisting = parser.parse(existingBookingEndTime);

                startTimeNew = parser.parse(newBookingStartTime);
                endTimeNew = parser.parse(newBookingEndTime);


                if (startTimeNew.after(startTimeExisting) && startTimeNew.before(endTimeExisting)) {
                    return false;
                } else if (startTimeNew.before(startTimeExisting) && (endTimeNew.after(startTimeExisting) || endTimeNew.equals(startTimeExisting))) {

                    return false;
                } else if (startTimeNew.after(startTimeExisting) && (endTimeExisting.before(startTimeNew) || endTimeExisting.equals(startTimeNew))) {
                    return true;
                } else if (startTimeNew.before(startTimeExisting) && (endTimeNew.before(startTimeExisting) || endTimeNew.equals(startTimeExisting))) {
                    return true;
                } else {
                    return false;
                }

            } catch (ParseException e) {
                return false;
            }

        }
    }

    public List<PlayZoneBooking> getBookRoomsByUser(User user) {
        Optional<List<PlayZoneBooking>> bookRooms = playZoneBookingRepository.findPLBookRoomsByUserEmail(user.getEmail());
        if (bookRooms.isEmpty()) {
            throw new CommonException("No Bookings found for provided email ");
        }
        return bookRooms.get();
    }


    public List<PlayZoneBooking> getAllBookings() {

        return playZoneBookingRepository.findAll();
    }
}
