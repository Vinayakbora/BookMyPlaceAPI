package com.bajaj.bookmyplace.models;

public class PlayZoneGetRequest {

    private Long locationId;

    public PlayZoneGetRequest() {

    }
    public PlayZoneGetRequest(Long locationId) {
        this.locationId = locationId;
    }

    public Long getLocationId() {
        return locationId;
    }

    public void setLocationId(Long locationId) {
        this.locationId = locationId;
    }
}
