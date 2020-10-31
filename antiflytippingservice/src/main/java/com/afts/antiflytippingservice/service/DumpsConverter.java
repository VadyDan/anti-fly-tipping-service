package com.afts.antiflytippingservice.service;

import com.afts.antiflytippingservice.dto.DumpsDto;
import com.afts.antiflytippingservice.entity.Dumps;
import org.springframework.stereotype.Component;

@Component
public class DumpsConverter {
    public Dumps fromDumpDtoToDump(DumpsDto dumpsDto) {
        Dumps dumps = new Dumps();
        dumps.setId(dumpsDto.getId());
        dumps.setDate(dumpsDto.getDate());
        dumps.setLongitude(dumpsDto.getLongitude());
        dumps.setLatitude(dumpsDto.getLatitude());
        return dumps;
    }

    public DumpsDto fromDumpToDumpDto(Dumps dumps) {
        DumpsDto dumpsDto = new DumpsDto();
        dumpsDto.setId(dumps.getId());
        dumpsDto.setDate(dumps.getDate());
        dumpsDto.setLongitude(dumps.getLongitude());
        dumpsDto.setLatitude(dumps.getLatitude());
        return dumpsDto;
    }
}
