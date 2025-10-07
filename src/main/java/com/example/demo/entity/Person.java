package com.example.demo.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Name cannot be blank")
    @Size(min = 2, max = 50, message = "Name must be 2–50 characters long")
    private String name;

    @NotBlank(message = "Email cannot be blank")
    @Email(message = "Please provide a valid email address")
    @Column(unique = true)
    private String email;

    @NotNull(message = "Age cannot be null")
    @Min(value = 0, message = "Age must be positive")
    @Max(value = 120, message = "Age seems unrealistic")
    private Integer age;

    @NotBlank(message = "Gender cannot be blank")
    private String gender;

    @NotBlank(message = "Profession cannot be blank")
    private String profession;

    @NotNull(message = "Alive status must be provided")
    private Boolean isAlive;
}