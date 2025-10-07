package com.example.demo.dto;

import lombok.Data;

@Data
public class PersonResponse {
    private Long id;
    private String name;
    private String email;
    private Integer age;
    private String gender;
    private String profession;
    private Boolean isAlive;
}