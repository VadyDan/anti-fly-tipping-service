package com.afts.antiflytippingservice.repository;

import com.afts.antiflytippingservice.entity.Dump;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.List;

public interface DumpsRepository extends JpaRepository<Dump, Integer> {
    List<Dump> findByDate(Date date);
    List<Dump> findByDateBetween(Date startDate, Date endDate);
}
