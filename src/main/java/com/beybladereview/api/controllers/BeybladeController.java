package com.beybladereview.api.controllers;

import com.beybladereview.api.dto.PageResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;
import com.beybladereview.api.dto.BeybladeDto;
import com.beybladereview.api.service.IBeybladeService;

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

    @GetMapping("/beyblades")
    public ResponseEntity<PageResponse<BeybladeDto>> getBeyblades(
            @RequestParam(value = "pageNo", defaultValue = "0", required = false) int pageNo,
            @RequestParam(value = "pageSize", defaultValue = "10", required = false) int pageSize
    ) {
        PageResponse<BeybladeDto> response = beybladeService.getAllBeyblades(pageNo, pageSize);
        return ResponseEntity.ok(response);
    }

    @GetMapping("beyblade")
    public ResponseEntity<BeybladeDto> beybladeDetail(@RequestParam int id) {
        return ResponseEntity.ok(beybladeService.getBeybladeById(id));
    }

    @PutMapping("beyblade/update")
    public ResponseEntity<BeybladeDto> updateBeyblade(@RequestBody BeybladeDto beybladeDto, @RequestParam int id) {
        BeybladeDto response = beybladeService.updateBeyblade(beybladeDto, id);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @DeleteMapping("beyblade/delete")
    public ResponseEntity<String> deleteBeyblade(@RequestParam int id) {
        beybladeService.deleteBeybladeById(id);
        return new ResponseEntity<>("Beyblade deleted!", HttpStatus.OK);
    }
}