package com.afts.antiflytippingservice.repository;

import com.afts.antiflytippingservice.entity.Dumps;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;

public interface DumpsRepository extends JpaRepository<Dumps, Integer> {
    Dumps findDumpByDate(Date date);
}
