package com.afts.antiflytippingservice.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "DUMPS_TABLE_TEST") //Пока заменил название БД
public class Dump {
    @Id
    @SequenceGenerator(name = "genid", sequenceName = "DUMP_SEQ")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "genid")
    @Column(name = "DUMP_ID", unique = true, nullable = false)
    private Integer id;

    @Column(name = "DUMP_LONGITUDE", nullable = false)
    private Double longitude;

    @Column(name = "DUMP_LATITUDE", nullable = false)
    private Double latitude;

    @Column(name = "DUMP_DATE", nullable = false)
    private Date date;

    @Column(name = "DUMP_CONFIDENCE", nullable = false)
    private Double confidence;

    public Double getConfidence() {
        return confidence;
    }

    public void setConfidence(Double confidence) {
        this.confidence = confidence;
    }

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
