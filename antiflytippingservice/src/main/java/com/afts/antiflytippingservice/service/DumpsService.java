package com.afts.antiflytippingservice.service;

import com.afts.antiflytippingservice.dto.DumpDto;
import com.afts.antiflytippingservice.exception.WrongDateException;

import java.util.Date;
import java.util.List;

public interface DumpsService {
    DumpDto saveDump(DumpDto dumpDto) throws WrongDateException;
    void deleteDump(Integer dumpId);
    List<DumpDto> findDumpsByDate(Date startDate, Date endDate);
    List<DumpDto> findAll();
    void setDumpCorrectFalse(Integer dumpId);

    void setDumpCheckedTrue(Integer dumpId);
}
