package com.afts.antiflytippingservice.repository;

import com.afts.antiflytippingservice.entity.Dump;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import java.util.Date;
import java.util.List;

@Repository
public interface DumpsRepository extends JpaRepository<Dump, Integer> {
    List<Dump> findByDate(Date date);
    List<Dump> findByDateBetween(Date startDate, Date endDate);
}
