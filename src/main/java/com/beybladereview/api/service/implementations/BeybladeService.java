package com.beybladereview.api.service.implementations;

import org.springframework.stereotype.Service;
import com.beybladereview.api.dto.BeybladeDto;
import com.beybladereview.api.models.Beyblade;
import com.beybladereview.api.repository.IBeybladeRepository;
import com.beybladereview.api.service.IBeybladeService;

@Service
public class BeybladeService implements IBeybladeService{
    private final IBeybladeRepository beybladeRepository;

    public BeybladeService(IBeybladeRepository beybladeRepository) {
        this.beybladeRepository = beybladeRepository;
    }

    @Override
    public BeybladeDto createBeyblade(BeybladeDto beybladeDto) {
        Beyblade beyblade = new Beyblade();
        beyblade.setName(beybladeDto.getName());
        beyblade.setBlader(beybladeDto.getBlader());
        beyblade.setSeries(beybladeDto.getSeries());
        beyblade.setType(beybladeDto.getType());
        beyblade.setBitBeast(beybladeDto.getBitBeast());
        beyblade.setSystem(beybladeDto.getSystem());
        beyblade.setSpinDirection(beybladeDto.getSpinDirection());
        beyblade.setAttackPower(beybladeDto.getAttackPower());
        beyblade.setDefensePower(beybladeDto.getDefensePower());
        beyblade.setStaminaPower(beybladeDto.getStaminaPower());
        beyblade.setDescription(beybladeDto.getDescription());
        
        Beyblade newBeyblade = beybladeRepository.save(beyblade);

        BeybladeDto beybladeResponse = new BeybladeDto();
        beybladeResponse.setId(newBeyblade.getId());
        beybladeResponse.setName(newBeyblade.getName());
        beybladeResponse.setBlader(newBeyblade.getBlader());
        beybladeResponse.setSeries(newBeyblade.getSeries());
        beybladeResponse.setType(newBeyblade.getType());
        beybladeResponse.setBitBeast(newBeyblade.getBitBeast());
        beybladeResponse.setSystem(newBeyblade.getSystem());
        beybladeResponse.setSpinDirection(newBeyblade.getSpinDirection());
        beybladeResponse.setAttackPower(newBeyblade.getAttackPower());
        beybladeResponse.setDefensePower(newBeyblade.getDefensePower());
        beybladeResponse.setStaminaPower(newBeyblade.getStaminaPower());
        beybladeResponse.setDescription(newBeyblade.getDescription());

        return beybladeResponse;
    }
}