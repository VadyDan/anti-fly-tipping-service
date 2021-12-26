package com.afts.antiflytippingservice.service;

import com.afts.antiflytippingservice.dto.DumpDto;
import com.afts.antiflytippingservice.entity.Dump;
import com.afts.antiflytippingservice.exception.NullDumpException;
import com.afts.antiflytippingservice.exception.WrongDateException;
import com.afts.antiflytippingservice.repository.DumpsRepository;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import static java.util.Objects.isNull;

@Service
public class DefaultDumpsService implements DumpsService {
    private final DumpsRepository dumpsRepository;
    private final DumpsConverter dumpsConverter;

    public DefaultDumpsService(DumpsRepository dumpsRepository, DumpsConverter dumpsConverter) {
        this.dumpsRepository = dumpsRepository;
        this.dumpsConverter = dumpsConverter;
    }

    private void validateDumpDto(DumpDto dumpDto) {
        if (isNull(dumpDto)) {
            throw new NullDumpException();
        }
        if (isNull(dumpDto.getDate()) || dumpDto.getDate().toString().isEmpty()) {
            throw new WrongDateException();
        }
        if (dumpDto.getDate().after(java.util.Calendar.getInstance().getTime())) {
            throw new WrongDateException();
        }
    }

    @Override
    public DumpDto saveDump(DumpDto dumpDto) {
        validateDumpDto(dumpDto);
        Dump savedDump = dumpsRepository.save(dumpsConverter.fromDumpDtoToDump(dumpDto));
        return dumpsConverter.fromDumpToDumpDto(savedDump);
    }

    @Override
    public void deleteDump(Integer dumpId) {
        dumpsRepository.deleteById(dumpId);
    }

    @Override
    public List<DumpDto> findDumpsByDate(Date startDate, Date endDate) {
        return dumpsRepository.findByDateBetween(startDate, endDate)
                .stream()
                .map(dumpsConverter::fromDumpToDumpDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<DumpDto> findAll() {
        return dumpsRepository.findAll()
                .stream()
                .map(dumpsConverter::fromDumpToDumpDto)
                .collect(Collectors.toList());
    }
}