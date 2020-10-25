package com.afts.antiflytippingservice.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "dumps_table")
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
}
