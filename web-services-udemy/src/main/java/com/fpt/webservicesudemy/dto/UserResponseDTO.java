package com.fpt.webservicesudemy.dto;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;

@Data
@Builder
public class UserResponseDTO {

    private Integer id;
    private String name;
    private LocalDate birthDate;
}
