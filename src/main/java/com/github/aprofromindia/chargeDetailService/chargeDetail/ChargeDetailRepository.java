package com.github.aprofromindia.chargeDetailService.chargeDetail;

import org.springframework.data.domain.Sort;
import org.springframework.data.repository.CrudRepository;
import org.springframework.lang.NonNull;

import java.util.List;
import java.util.UUID;

public interface ChargeDetailRepository extends CrudRepository<ChargeDetail, UUID> {
    List<ChargeDetail> findByVehicleIdIgnoreCase(@NonNull String vehicleId, @NonNull Sort sort);
}