package com.fpt.webservicesudemy.dto;

import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;

@Data
@Builder
public class CreateUserDTO {

    @Size(min = 2, message = "Name has at least 2 characters.")
    private String name;

    @Past(message = "Birthday is not after system date.")
    private LocalDate birthDate;
}
