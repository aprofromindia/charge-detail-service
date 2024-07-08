package com.github.aprofromindia.chargeDetailService.error;

import org.springframework.http.HttpStatus;

public record ApiError(HttpStatus httpStatus, String message) {
}
