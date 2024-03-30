package com.bajaj.bookmyplace.models;

import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;

import java.util.Date;

@Entity
@Table(name = "play_zone_bookings")
public class PlayZoneBooking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private Long id;


    @ManyToOne
    @JoinColumn(name = "play_zone_id")
    private PlayZone playZone;


    @Column( nullable = false)
    private String userEmail;

    @Column( nullable = false)
    private String startTime;

    @Column( nullable = false)
    private String endTime;

    @Column(name = "pz_booking_date", nullable = false)
    private String bookingDate;

    @Column(name = "timestamp", nullable = false, updatable = false)
    @CreationTimestamp
    private Date timestamp;

    public PlayZoneBooking() {

    }

    public PlayZoneBooking(Long id, PlayZone playZone, String userEmail, String startTime, String endTime, String bookingDate, Date timestamp) {
        this.id = id;
        this.playZone = playZone;
        this.userEmail = userEmail;
        this.startTime = startTime;
        this.endTime = endTime;
        this.bookingDate = bookingDate;
        this.timestamp = timestamp;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public PlayZone getPLayZone() {
        return playZone;
    }

    public void setPLayZone(PlayZone playZone) {
        this.playZone = playZone;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public String getBookingDate() {
        return bookingDate;
    }

    public void setBookingDate(String bookingDate) {
        this.bookingDate = bookingDate;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }
}
