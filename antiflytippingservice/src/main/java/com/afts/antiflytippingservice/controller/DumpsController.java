package com.afts.antiflytippingservice.controller;

import com.afts.antiflytippingservice.dto.DumpsDto;
import com.afts.antiflytippingservice.exception.ValidationException;
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
    public DumpsDto findDumpByDate(@RequestParam String date) throws ParseException {
        //Используется старая технология перевода времени, можно будет поменять
        SimpleDateFormat formatForDateNow = new SimpleDateFormat("yyyy-MM-dd");
        Date date1 = formatForDateNow.parse(date);
        log.info("Handling find by date request: " + formatForDateNow.format(date1));
        return dumpsService.findDumpByDate(date1);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteDumps(@PathVariable Integer id) {
        log.info("Handling delete dump request: " + id);
        dumpsService.deleteDump(id);
        return ResponseEntity.ok().build();
    }
}
