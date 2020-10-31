package com.afts.antiflytippingservice.controller;

import com.afts.antiflytippingservice.dto.DumpsDto;
import com.afts.antiflytippingservice.exception.ValidationException;
import com.afts.antiflytippingservice.service.DumpsService;
import lombok.AllArgsConstructor;
import lombok.extern.java.Log;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@Log
@RestController
@AllArgsConstructor
@RequestMapping("/dumps")
public class DumpsController {
    public final DumpsService dumpsService;

    @PostMapping("/save")
    public DumpsDto saveDumps(@RequestBody DumpsDto dumpsDto) throws ValidationException {
        log.info("Handling save dumps: " + dumpsDto);
        return dumpsService.saveDump(dumpsDto);
    }

    @GetMapping("/findAll")
    public List<DumpsDto> findAllDumps() {
        log.info("Handling find all dumps request");
        return dumpsService.findAll();
    }

    @GetMapping("/findDumpByDate")
    public DumpsDto findDumpByDate(@RequestParam Date date) {
        log.info("Handling find by date request: " + date);
        return dumpsService.findDumpByDate(date);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteDumps(@PathVariable Integer id) {
        log.info("Handling delete dump request: " + id);
        dumpsService.deleteDump(id);
        return ResponseEntity.ok().build();
    }
}
