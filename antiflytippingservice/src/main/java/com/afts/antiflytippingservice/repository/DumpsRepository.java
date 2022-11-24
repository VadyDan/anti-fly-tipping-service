package com.afts.antiflytippingservice.repository;

import com.afts.antiflytippingservice.entity.Dump;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


import java.util.Date;
import java.util.List;

@Repository
public interface DumpsRepository extends JpaRepository<Dump, Integer> {
    List<Dump> findByDate(Date date);
    List<Dump> findByDateBetween(Date startDate, Date endDate);
    List<Dump> findByCorrectTrue();
    @Transactional
    @Modifying
    @Query("update Dump d set d.correct = false where d.id = :id")
    void setDumpCorrectFalse(@Param("id") Integer id);
}
