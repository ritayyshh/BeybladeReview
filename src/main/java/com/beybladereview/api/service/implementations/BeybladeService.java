package com.beybladereview.api.service.implementations;

import com.beybladereview.api.dto.PageResponse;
import com.beybladereview.api.utils.PaginationUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.PageRequest;
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
        Beyblade beyblade = mapToEntity(beybladeDto);
        Beyblade saved = beybladeRepository.save(beyblade);

        return mapToDto(saved);
    }

    @Override
    public PageResponse<BeybladeDto> getAllBeyblades(int pageNo, int pageSize) {
        Pageable pageable = PageRequest.of(pageNo, pageSize);
        Page<Beyblade> page = beybladeRepository.findAll(pageable);

        return PaginationUtils.toPageResponse(page, this::mapToDto);
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