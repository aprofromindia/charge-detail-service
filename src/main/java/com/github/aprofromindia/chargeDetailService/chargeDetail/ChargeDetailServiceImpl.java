package com.github.aprofromindia.chargeDetailService.chargeDetail;

import jakarta.validation.Valid;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ChargeDetailServiceImpl implements ChargeDetailService {
    private final ChargeDetailRepository repository;

    @Override
    public Optional<ChargeDetail> findById(@NonNull UUID id) {
        return repository.findById(id);
    }

    @Override
    public List<ChargeDetail> findChargeDetailsForVehicleId(@NonNull String vehicleId, @NonNull String sortBy) {
        return repository.findByVehicleIdIgnoreCase(vehicleId, Sort.by(Sort.Direction.DESC, sortBy));
    }

    @Override
    public ChargeDetail save(@Valid ChargeDetail chargeDetail) {
        return repository.save(chargeDetail);
    }
}
