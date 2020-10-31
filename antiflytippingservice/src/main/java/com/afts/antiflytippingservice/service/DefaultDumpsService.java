package com.afts.antiflytippingservice.service;

import com.afts.antiflytippingservice.dto.DumpsDto;
import com.afts.antiflytippingservice.entity.Dumps;
import com.afts.antiflytippingservice.exception.ValidationException;
import com.afts.antiflytippingservice.repository.DumpsRepository;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import static java.util.Objects.isNull;

@Service
public class DefaultDumpsService implements DumpsService{
    private final DumpsRepository dumpsRepository;
    private final DumpsConverter dumpsConverter;

    public DefaultDumpsService(DumpsRepository dumpsRepository, DumpsConverter dumpsConverter) {
        this.dumpsRepository = dumpsRepository;
        this.dumpsConverter = dumpsConverter;
    }

    private void validateDumpDto(DumpsDto dumpsDto) throws ValidationException {
        if (isNull(dumpsDto)) {
            throw new ValidationException("Object dump is null!");
        }
        if (isNull(dumpsDto.getDate()) || dumpsDto.getDate().toString().isEmpty()) {
            throw new ValidationException("Date is empty!");
        }
        if (dumpsDto.getDate().after(java.util.Calendar.getInstance().getTime())) {
            throw new ValidationException("Date is wrong!");
        }
    }

    @Override
    public DumpsDto saveDump(DumpsDto dumpsDto) throws ValidationException {
        validateDumpDto(dumpsDto);
        Dumps savedDump = dumpsRepository.save(dumpsConverter.fromDumpDtoToDump(dumpsDto));
        return dumpsConverter.fromDumpToDumpDto(savedDump);
    }

    @Override
    public void deleteDump(Integer dumpId) {
        dumpsRepository.deleteById(dumpId);
    }

    @Override
    public DumpsDto findDumpByDate(Date date) {
        Dumps dumps = dumpsRepository.findDumpByDate(date);
        if (dumps != null) {
            return dumpsConverter.fromDumpToDumpDto(dumps);
        }
        return null;
    }

    @Override
    public List<DumpsDto> findAll() {
        return dumpsRepository.findAll()
                .stream()
                .map(dumpsConverter::fromDumpToDumpDto)
                .collect(Collectors.toList());
    }
}