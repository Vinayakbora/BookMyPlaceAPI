package com.bajaj.bookmyplace.models;

public class MeetingRoomGetRequest {

    private Long locationId;

    public MeetingRoomGetRequest() {

    }
    public MeetingRoomGetRequest(Long locationId) {
        this.locationId = locationId;
    }

    public Long getLocationId() {
        return locationId;
    }

    public void setLocationId(Long locationId) {
        this.locationId = locationId;
    }
}
