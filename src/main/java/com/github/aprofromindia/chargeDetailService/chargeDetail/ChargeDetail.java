package com.github.aprofromindia.chargeDetailService.chargeDetail;

import jakarta.persistence.*;
import jakarta.validation.constraints.AssertTrue;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.UUID;

@Getter
@Setter
@Entity
@Table(name = "charge_detail", indexes = {
        @Index(name = "idx_charge_detail_vehicle_id", columnList = "vehicle_id")
})
@EntityListeners(AuditingEntityListener.class)
public class ChargeDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id", nullable = false, updatable = false)
    private UUID id;

    @NotBlank(message = "vehicleId, cannot be blank")
    @Column(name = "vehicle_id", nullable = false, updatable = false)
    private String vehicleId;

    @PastOrPresent(message = "startDate, cannot be in the future.")
    @Column(name = "created_date", updatable = false)
    private Instant startDate;

    @Column(name = "end_date")
    private Instant endDate;

    @PositiveOrZero(message = "cost, cannot be less than zero")
    @Column(name = "cost", precision = 19, scale = 2)
    private BigDecimal cost;

    @Version
    @Column(name = "version")
    private Integer version;

    @AssertTrue(message = "endDate, cannot be before startDate.")
    boolean isValidEndDate() {
        return endDate == null || startDate.isBefore(endDate);
    }
}