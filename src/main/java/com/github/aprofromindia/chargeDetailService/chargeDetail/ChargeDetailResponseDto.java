package com.github.aprofromindia.chargeDetailService.chargeDetail;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.UUID;

public record ChargeDetailResponseDto(UUID id, String vehicleId, Instant startDate, Instant endDate, BigDecimal cost,
                                      Integer version) {
}
