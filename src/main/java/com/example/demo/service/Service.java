package com.example.demo.service;

import com.example.demo.dto.PersonRequest;
import com.example.demo.dto.PersonResponse;

import java.util.List;

public interface Service {
    PersonResponse create(PersonRequest request);
    List<PersonResponse> getAll();
    PersonResponse getById(Long id);
    PersonResponse update(Long id, PersonRequest request);
    void delete(Long id);
}