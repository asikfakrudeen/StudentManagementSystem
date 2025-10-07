package com.example.demo.dto;

import lombok.Data;
import jakarta.validation.constraints.*;

@Data
public class PersonRequest {
    @NotBlank(message = "Name cannot be blank")
    private String name;

    @NotBlank(message = "Email cannot be blank")
    @Email(message = "Invalid email format")
    private String email;

    @NotNull(message = "Age cannot be null")
    @Min(value = 0, message = "Age must be >= 0")
    @Max(value = 120, message = "Age seems unrealistic")
    private Integer age;

    @NotBlank(message = "Gender cannot be blank")
    private String gender;

    @NotBlank(message = "Profession cannot be blank")
    private String profession;

    @NotNull(message = "Alive status must be provided")
    private Boolean isAlive;
}