package com.beybladereview.api.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
import org.springframework.http.HttpStatus;
import com.beybladereview.api.dto.BeybladeDto;
import com.beybladereview.api.service.IBeybladeService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
@RequestMapping("/api/")
public class BeybladeController {
    private final IBeybladeService beybladeService;

    public BeybladeController(IBeybladeService beybladeService) {
        this.beybladeService = beybladeService;
    }

    @PostMapping("beyblade/create")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<BeybladeDto> createBeyblade(@RequestBody BeybladeDto beybladeDto) {
        return new ResponseEntity<BeybladeDto>(beybladeService.createBeyblade(beybladeDto), HttpStatus.CREATED);     
    }

    @GetMapping("beyblades")
    public ResponseEntity<List<BeybladeDto>> getBeyblades() {
        return new ResponseEntity<>(beybladeService.getAllBeyblades(), HttpStatus.OK);
    }
    
    @GetMapping("beyblade")
    public ResponseEntity<BeybladeDto> beybladeDetail(@RequestParam int id) {
        return ResponseEntity.ok(beybladeService.getBeybladeById(id));
    } 
}