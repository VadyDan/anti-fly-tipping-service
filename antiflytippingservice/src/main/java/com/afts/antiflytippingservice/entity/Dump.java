package com.afts.antiflytippingservice.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "DUMPS_TABLE")
public class Dump {
    @Id
    @SequenceGenerator(name = "DUMP_ID_SEQ", sequenceName = "DUMP_ID_SEQ")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "DUMP_ID_SEQ")
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

    @Column(name = "DUMP_CORRECT", nullable = false)
    private boolean correct;

    @Column(name = "DUMP_CHECKED", nullable = false)
    private boolean checked;

    @Column(name = "DUMP_IMAGE")
    private byte[] image;

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

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }

    public boolean getCorrect() {
        return correct;
    }

    public void setCorrect(boolean correct) {
        this.correct = correct;
    }

    public boolean isChecked() {
        return checked;
    }

    public void setChecked(boolean checked) {
        this.checked = checked;
    }
}
