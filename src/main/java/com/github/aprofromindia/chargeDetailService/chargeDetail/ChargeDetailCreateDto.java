package com.github.aprofromindia.chargeDetailService.chargeDetail;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.AssertTrue;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.PositiveOrZero;

import java.math.BigDecimal;
import java.time.Instant;

public record ChargeDetailCreateDto(@NotBlank(message = "vehicleId, cannot be blank") String vehicleId,
                                    @PastOrPresent(message = "startDate, cannot be in the future")
                                    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSX") Instant startDate,
                                    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSX") Instant endDate,
                                    @PositiveOrZero(message = "cost, cannot be less than zero") BigDecimal cost) {

    @AssertTrue(message = "endDate, cannot be before startDate.")
    boolean isValidEndDate() {
        return endDate == null || startDate.isBefore(endDate);
    }
}
