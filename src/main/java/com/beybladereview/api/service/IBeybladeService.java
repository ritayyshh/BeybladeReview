package com.beybladereview.api.service;

import java.util.List;
import com.beybladereview.api.dto.BeybladeDto;

public interface IBeybladeService {
    BeybladeDto createBeyblade(BeybladeDto beyblade);
    List<BeybladeDto> getAllBeyblades();
    BeybladeDto getBeybladeById(int id);
}