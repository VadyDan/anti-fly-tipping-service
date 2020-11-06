package com.afts.antiflytippingservice.dto;

import java.util.Date;

public class DumpDto {
    private Integer id;
    private Double longitude;
    private Double latitude;
    private Date date;

    public Integer getId() {
        return id;
    }

    public Date getDate() {
        return date;
    }

    public Double getLongitude() {
        return longitude;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }
}
