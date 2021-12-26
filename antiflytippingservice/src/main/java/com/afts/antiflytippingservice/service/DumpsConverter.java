package com.afts.antiflytippingservice.service;

import com.afts.antiflytippingservice.dto.DumpDto;
import com.afts.antiflytippingservice.entity.Dump;
import org.springframework.stereotype.Component;

@Component
public class DumpsConverter {
    public Dump fromDumpDtoToDump(DumpDto dumpDto) {
        Dump dump = new Dump();
        dump.setId(dumpDto.getId());
        dump.setDate(dumpDto.getDate());
        dump.setLongitude(dumpDto.getLongitude());
        dump.setLatitude(dumpDto.getLatitude());
        dump.setConfidence(dumpDto.getConfidence());
        return dump;
    }

    public DumpDto fromDumpToDumpDto(Dump dump) {
        DumpDto dumpDto = new DumpDto();
        dumpDto.setId(dump.getId());
        dumpDto.setDate(dump.getDate());
        dumpDto.setLongitude(dump.getLongitude());
        dumpDto.setLatitude(dump.getLatitude());
        dumpDto.setConfidence(dump.getConfidence());
        return dumpDto;
    }
}
