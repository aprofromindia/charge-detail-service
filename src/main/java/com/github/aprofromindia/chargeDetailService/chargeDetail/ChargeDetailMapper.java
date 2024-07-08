package com.github.aprofromindia.chargeDetailService.chargeDetail;

import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.mapstruct.ReportingPolicy;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface ChargeDetailMapper {
    ChargeDetail toEntity(ChargeDetailCreateDto chargeDetailCreateDto);

    ChargeDetailResponseDto toResponseDto(ChargeDetail chargeDetail);
}