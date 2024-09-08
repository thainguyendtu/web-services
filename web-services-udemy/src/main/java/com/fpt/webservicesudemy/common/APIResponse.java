package com.fpt.webservicesudemy.common;

import lombok.Builder;
import lombok.Data;

//@Builder
@Data
@Builder
public class APIResponse<T> {

    private int statusCode;
    private String message;
    private T data;

    public APIResponse(int statusCode, String message, T data) {
        this.statusCode = statusCode;
        this.message = message;
        this.data = data;
    }
}
