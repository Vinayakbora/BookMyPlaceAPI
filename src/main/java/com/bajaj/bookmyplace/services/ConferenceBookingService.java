package com.bajaj.bookmyplace.services;

import com.bajaj.bookmyplace.exceptions.CommonException;
import com.bajaj.bookmyplace.models.ConferenceBooking;
import com.bajaj.bookmyplace.models.Location;
import com.bajaj.bookmyplace.models.MeetingRoom;
import com.bajaj.bookmyplace.models.User;
import com.bajaj.bookmyplace.repository.ConferenceBookingRepository;
import com.bajaj.bookmyplace.repository.MeetingRoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class ConferenceBookingService {

    @Autowired
    ConferenceBookingRepository conferenceBookingRepository;

    @Autowired
    MeetingRoomRepository meetingRoomRepository;


    public ConferenceBooking createBookRoom(ConferenceBooking conferenceBookingNew)  {


        Optional<ConferenceBooking> conferenceBookingExisting =  conferenceBookingRepository.findBookRoomsByBookingDate(conferenceBookingNew.getBookingDate());

        if (conferenceBookingExisting.isEmpty()) {

                ConferenceBooking conferenceBookingCreate = conferenceBookingRepository.save(conferenceBookingNew);
                return conferenceBookingCreate;


        }
         else{   ConferenceBooking conferenceBookingExisting1 = conferenceBookingExisting.get();
            Boolean isTimeSlotAvailabe = isTimeSlotAvailable(conferenceBookingExisting1, conferenceBookingNew);
            if(isTimeSlotAvailabe)
            {
                ConferenceBooking conferenceBookingCreate = conferenceBookingRepository.save(conferenceBookingNew);
                return conferenceBookingCreate;
            }
            throw new CommonException("Booking slot not available");
        }


    }

    private Boolean isTimeSlotAvailable(ConferenceBooking bookingExisting, ConferenceBooking newBooking)  {
        String existingBookingStartTime = bookingExisting.getStartTime();
        String existingBookingEndTime = bookingExisting.getEndTime();

        String newBookingStartTime = newBooking.getStartTime();
        String newBookingEndTime = newBooking.getEndTime();
        if(existingBookingStartTime .equals(newBookingStartTime)  ){
            return false;
        } else if (existingBookingStartTime != newBookingStartTime ) {
            SimpleDateFormat parser = new SimpleDateFormat("HH:mm");
            Date startTimeExisting = null;
            Date endTimeExisting = null;

            Date startTimeNew = null;
            Date endTimeNew = null;
            try {
                startTimeExisting = parser.parse(existingBookingStartTime);
                endTimeExisting = parser.parse(existingBookingEndTime);

                startTimeNew = parser.parse(newBookingStartTime);
                endTimeNew = parser.parse(newBookingEndTime);


              //1 //starttimenew=7:30
                // endtimenew=8:00

                // starttimeexisting=7:00
                // endtimeexisting=8:00

                if (startTimeNew.after(startTimeExisting) && startTimeNew.before(endTimeExisting)) {
                    return false;
                }

                //2//starttimenew=7:00
                // // endtimenew=8:00
                //
                // // starttimeexisting=7:30
                // // endtimeexisting=9:00
                else if (startTimeNew.before(startTimeExisting) && (endTimeNew.after(startTimeExisting) || endTimeNew.equals(startTimeExisting))) {

                    return false;
                }

                //3//starttimenew=7:00
                // // endtimenew=8:00
                //
                // // starttimeexisting=6:30
                // // endtimeexisting=7:00
                else if (startTimeNew.after(startTimeExisting) && (endTimeExisting.before(startTimeNew) || endTimeExisting.equals(startTimeNew))) {
                    return true;
                }

                //3//starttimenew=7:00
                // // endtimenew=7:30
                //
                // // starttimeexisting=7:30
                // // endtimeexisting=7:00
                else if (startTimeNew.before(startTimeExisting) && (endTimeNew.before(startTimeExisting) || endTimeNew.equals(startTimeExisting))) {
                    return true;
                }
                else{
                    return false;
                }

            } catch (ParseException e) {
                return false;
            }

        }
        return false;
    }

    public List<ConferenceBooking> getBookRoomsByUser(User user){
        Optional<List<ConferenceBooking>> bookRooms =  conferenceBookingRepository.findBookRoomsByUserEmail(user.getEmail());
        if (bookRooms.isEmpty()) {
            throw new CommonException("No Bookings found for provided email ");
        }
        return bookRooms.get();
    }

    public ConferenceBooking getBookRoomByDateAndTimeSlot(String bookingDate, String timeSlot){
        Optional<ConferenceBooking> bookRoom =  conferenceBookingRepository.findBookRoomsByBookingDate(bookingDate);
        if (bookRoom.isEmpty()) {
            throw new CommonException("No Booking found for provided timeslot and date ");
        }
        return bookRoom.get();
    }


    public List<ConferenceBooking> getAllBookings(){
        List<ConferenceBooking> bookRoomsOptional =  conferenceBookingRepository.findAll();

        return bookRoomsOptional;
    }


//    public List<MeetingRoom> getAllMeetingRoomsByLocation(Location location){
//        Optional <List<MeetingRoom>> meetingRoomsOptional =  meetingRoomRepository.findByLocation(location);
//        if (meetingRoomsOptional.isEmpty()){
//            throw new CommonException("No Room found for provided location ");
//        }
//        return meetingRoomsOptional.get();
//    }
}
