package com.github.aprofromindia.chargeDetailService.chargeDetail;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/chargeDetails")
@RequiredArgsConstructor
public class ChargeDetailController {

    private final ChargeDetailService service;
    private final ChargeDetailMapper mapper;

    @Operation(description = "Get a Charge Detail by id.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "ChargeDetail item retrieved.",
                    content = {@Content(mediaType = "application/json", schema = @Schema(implementation = ChargeDetailResponseDto.class))}),
            @ApiResponse(responseCode = "404", description = "Item not found.", content = @Content)
    })
    @GetMapping("/{id}")
    ChargeDetailResponseDto getChargeDetail(@NonNull @PathVariable UUID id) {
        return service.findById(id).map(mapper::toResponseDto)
                .orElseThrow(() -> new IllegalArgumentException(String.format("Invalid uuid provided - %s", id)));
    }

    @Operation(description = "Get all Charge Details for a vehicle id.")
    @GetMapping
    ResponseEntity<List<ChargeDetailResponseDto>> getAllForVehicle(@RequestParam("vn") String vehicleNumber,
                                                                   @RequestParam Optional<String> sortBy) {
        var chargeDetails = service.findChargeDetailsForVehicleId(vehicleNumber, sortBy.orElse("startDate")).parallelStream()
                .map(mapper::toResponseDto).collect(Collectors.toList());
        return ResponseEntity.ok(chargeDetails);
    }

    @Operation(summary = "Create a new ChargeDetail object")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "New ChargeDetail object created.",
                    content = {@Content(mediaType = "application/json", schema = @Schema(implementation = ChargeDetailResponseDto.class))}),
            @ApiResponse(responseCode = "400", description = "Invalid request body provided.", content = @Content)
    })
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    ChargeDetailResponseDto createChargeDetail(@Valid @RequestBody ChargeDetailCreateDto dto) {
        return mapper.toResponseDto(service.save(mapper.toEntity(dto)));
    }
}
