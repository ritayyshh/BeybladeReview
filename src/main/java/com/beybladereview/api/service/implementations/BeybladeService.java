package com.beybladereview.api.service.implementations;

import java.util.List;
import java.util.stream.Collectors;
import org.springframework.stereotype.Service;
import com.beybladereview.api.dto.BeybladeDto;
import com.beybladereview.api.exceptions.BeybladeNotFoundException;
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

    @Override
    public List<BeybladeDto> getAllBeyblades() {
        List<Beyblade> beyblades = beybladeRepository.findAll();
        return beyblades.stream().map(b -> mapToDto(b)).collect(Collectors.toList());
    }

    @Override
    public BeybladeDto getBeybladeById(int id) {
        Beyblade beyblade = beybladeRepository.findById(id).orElseThrow(() -> new BeybladeNotFoundException("Beyblade could not be found!"));
        return mapToDto(beyblade);
    }

    @Override
    public BeybladeDto updateBeyblade(BeybladeDto beybladeDto, int id) {
        Beyblade beyblade = beybladeRepository.findById(id).orElseThrow(() -> new BeybladeNotFoundException("Beyblade could not be found!"));

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

        Beyblade updatedBeyblade = beybladeRepository.save(beyblade);
        return mapToDto(updatedBeyblade);
    }

    @Override
    public void deleteBeybladeById(int id) {
        Beyblade beyblade = beybladeRepository.findById(id).orElseThrow(() -> new BeybladeNotFoundException("Beyblade could not be found!"));
        beybladeRepository.delete(beyblade);
    }

    private BeybladeDto mapToDto(Beyblade beyblade) {
        BeybladeDto beybladeDto = new BeybladeDto();
        beybladeDto.setId(beyblade.getId());
        beybladeDto.setName(beyblade.getName());
        beybladeDto.setBlader(beyblade.getBlader());
        beybladeDto.setSeries(beyblade.getSeries());
        beybladeDto.setType(beyblade.getType());
        beybladeDto.setBitBeast(beyblade.getBitBeast());
        beybladeDto.setSystem(beyblade.getSystem());
        beybladeDto.setSpinDirection(beyblade.getSpinDirection());
        beybladeDto.setAttackPower(beyblade.getAttackPower());
        beybladeDto.setDefensePower(beyblade.getDefensePower());
        beybladeDto.setStaminaPower(beyblade.getStaminaPower());
        beybladeDto.setDescription(beyblade.getDescription());
        return beybladeDto;
    }

    private Beyblade mapToEntity(BeybladeDto beybladeDto) {
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
        return beyblade;
    }
}