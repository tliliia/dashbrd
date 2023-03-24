package com.tronina.dashbrd.exception;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
class ErrorResponse {

    private String exceptionType;

    private String message;

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    private String stacktrace;
}
