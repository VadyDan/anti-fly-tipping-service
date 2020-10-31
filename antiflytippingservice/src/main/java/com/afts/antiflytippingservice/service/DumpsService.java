package com.afts.antiflytippingservice.service;

import com.afts.antiflytippingservice.dto.DumpsDto;
import com.afts.antiflytippingservice.exception.ValidationException;

import java.util.Date;
import java.util.List;

public interface DumpsService {
    DumpsDto saveDump(DumpsDto dumpsDto) throws ValidationException;
    void deleteDump(Integer dumpId);
    DumpsDto findDumpByDate(Date date);
    List<DumpsDto> findAll();
}
