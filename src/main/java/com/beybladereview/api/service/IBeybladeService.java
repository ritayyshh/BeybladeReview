package com.beybladereview.api.service;

import java.util.List;
import com.beybladereview.api.dto.BeybladeDto;

public interface IBeybladeService {
    BeybladeDto createBeyblade(BeybladeDto beybladeDto);
    List<BeybladeDto> getAllBeyblades();
    BeybladeDto getBeybladeById(int id);
    BeybladeDto updateBeyblade(BeybladeDto beybladeDto, int id);
    void deleteBeybladeById(int id);
}