package com.beybladereview.api.service;

import com.beybladereview.api.dto.BeybladeDto;
import com.beybladereview.api.dto.BeybladeResponse;

public interface IBeybladeService {
    BeybladeDto createBeyblade(BeybladeDto beybladeDto);
    BeybladeResponse getAllBeyblades(int pageNo, int pageSize);
    BeybladeDto getBeybladeById(int id);
    BeybladeDto updateBeyblade(BeybladeDto beybladeDto, int id);
    void deleteBeybladeById(int id);
}