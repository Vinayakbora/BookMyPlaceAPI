package com.bajaj.bookmyplace.models;

import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;

import java.util.Date;
import java.util.List;

@Entity
@Table(name = "locations")
public class Location {

    public Location(){

    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    private String city;

    @Column(nullable = false)
    private String name;

    @Column(name = "timestamp", nullable = false, updatable = false)
    @CreationTimestamp
    private Date timestamp;

    @OneToMany(mappedBy = "location", cascade = CascadeType.ALL)
    private List<MeetingRoom> meetingRooms;


    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }

    public List<MeetingRoom> getMeetingRooms() {
        return meetingRooms;
    }

    public void setMeetingRooms(List<MeetingRoom> meetingRooms) {
        this.meetingRooms = meetingRooms;
    }

    public Location(Long id, String city, String name, Date timestamp, List<MeetingRoom> meetingRooms) {
        this.id = id;
        this.city = city;
        this.name = name;
        this.timestamp = timestamp;
        this.meetingRooms = meetingRooms;
    }
}
