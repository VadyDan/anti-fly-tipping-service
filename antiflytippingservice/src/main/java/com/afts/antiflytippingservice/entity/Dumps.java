package com.afts.antiflytippingservice.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "dumps_table_test") //Пока заменил название БД
public class Dumps {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column
    private Double longitude;

    @Column
    private Double latitude;

    @Column
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
