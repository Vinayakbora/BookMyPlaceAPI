package com.bajaj.bookmyplace.models;

import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;

import java.util.Date;

@Entity
@Table(name = "bookrooms")
public class BookRoom {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private Long id;


    @ManyToOne
    @JoinColumn(name = "meeting_room_id")
    private MeetingRoom meetingRoom;


    @Column( nullable = false)
    private String userEmail;

    @Column( nullable = false)
    private String timeSlot;

    @Column(name = "booking_date", nullable = false)
    private Date bookingDate;

    @Column(name = "timestamp", nullable = false, updatable = false)
    @CreationTimestamp
    private Date timestamp;

    public BookRoom() {

    }

    public BookRoom(Long id, MeetingRoom meetingRoom, String userEmail, String timeSlot, Date bookingDate, Date timestamp) {
        this.id = id;
        this.meetingRoom = meetingRoom;
        this.userEmail = userEmail;
        this.timeSlot = timeSlot;
        this.bookingDate = bookingDate;
        this.timestamp = timestamp;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public MeetingRoom getMeetingRoom() {
        return meetingRoom;
    }

    public void setMeetingRoom(MeetingRoom meetingRoom) {
        this.meetingRoom = meetingRoom;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUser(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getTimeSlot() {
        return timeSlot;
    }

    public void setTimeSlot(String timeSlot) {
        this.timeSlot = timeSlot;
    }

    public Date getBookingDate() {
        return bookingDate;
    }

    public void setBookingDate(Date bookingDate) {
        this.bookingDate = bookingDate;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }
}
