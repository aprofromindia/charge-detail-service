package com.github.aprofromindia.chargeDetailService.chargeDetail;

import jakarta.validation.Valid;
import lombok.NonNull;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface ChargeDetailService {
    Optional<ChargeDetail> findById(@NonNull UUID id);

    List<ChargeDetail> findChargeDetailsForVehicleId(@NonNull String vehicleId, String sortBy);

    ChargeDetail save(@Valid ChargeDetail chargeDetail);
}
