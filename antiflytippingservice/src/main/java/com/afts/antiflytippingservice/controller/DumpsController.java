package com.afts.antiflytippingservice.controller;

import com.afts.antiflytippingservice.dto.DumpDto;
import com.afts.antiflytippingservice.service.DumpsService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.logging.Logger;

@RestController
@RequestMapping("/dumps")
public class DumpsController {
    public final DumpsService dumpsService;
    private static Logger log = Logger.getLogger(DumpsController.class.getName());

    public DumpsController(DumpsService dumpsService) {
        this.dumpsService = dumpsService;
    }

    @PostMapping("/save")
    public DumpDto saveDumps(@RequestBody DumpDto dumpDto) {
        log.info("Handling save dumps: " + dumpDto);
        return dumpsService.saveDump(dumpDto);
    }

    @GetMapping("/findAll")
    public List<DumpDto> findAllDumps() {
        log.info("Handling find all dumps request");
        return dumpsService.findAll();
    }

    @GetMapping("/findDumpByDate")
    public List<DumpDto> findDumpByDate(@RequestParam String startDate, @RequestParam String endDate) throws ParseException {
        //Используется старая технология перевода времени, можно будет поменять
        SimpleDateFormat formatForDateNow = new SimpleDateFormat("yyyy-MM-dd");
        Date date1 = formatForDateNow.parse(startDate);
        Date date2 = formatForDateNow.parse(endDate);
        log.info("Handling find by date request: " + formatForDateNow.format(date1) + " - " + formatForDateNow.format(date2));
        return dumpsService.findDumpsByDate(date1, date2);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteDumps(@PathVariable Integer id) {
        log.info("Handling delete dump request: " + id);
        dumpsService.deleteDump(id);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/setDumpCorrectFalse/{id}")
    public ResponseEntity<Void> setDumpCorrectFalse(@PathVariable Integer id) {
        log.info("Set Dump Correct = False: id = " + id);
        dumpsService.setDumpCorrectFalse(id);
        return ResponseEntity.ok().build();
    }
}
