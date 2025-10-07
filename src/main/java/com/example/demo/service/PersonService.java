package com.example.demo.service;

import com.example.demo.dto.PersonRequest;
import com.example.demo.dto.PersonResponse;
import com.example.demo.entity.Person;
import com.example.demo.repository.PersonRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PersonService implements com.example.demo.service.Service {

    private final PersonRepository personRepository;

    @Override
    public PersonResponse create(PersonRequest request) {
        Person person = Person.builder()
                .name(request.getName())
                .email(request.getEmail())
                .age(request.getAge())
                .gender(request.getGender())
                .profession(request.getProfession())
                .isAlive(request.getIsAlive())
                .build();

        Person saved = personRepository.save(person);
        return mapToResponse(saved);
    }

    @Override
    public List<PersonResponse> getAll() {
        List<Person> people = personRepository.findAll();
        List<PersonResponse> responses = new ArrayList<>();

        for (Person person : people) {
            responses.add(mapToResponse(person));
        }
        return responses;
    }

    @Override
    public PersonResponse getById(Long id) {
        Person person = personRepository.findById(id)
                .orElseThrow(() -> new com.example.demo.exception.ResourceNotFoundException("Person not found"));
        return mapToResponse(person);
    }

    @Override
    public PersonResponse update(Long id, PersonRequest request) {
        Person person = personRepository.findById(id)
                .orElseThrow(() -> new com.example.demo.exception.ResourceNotFoundException("Person not found"));

        person.setName(request.getName());
        person.setEmail(request.getEmail());
        person.setAge(request.getAge());
        person.setGender(request.getGender());
        person.setProfession(request.getProfession());
        person.setIsAlive(request.getIsAlive());

        Person updated = personRepository.save(person);
        return mapToResponse(updated);
    }

    @Override
    public void delete(Long id) {
        personRepository.deleteById(id);
    }

    private PersonResponse mapToResponse(Person person) {
        PersonResponse response = new PersonResponse();
        response.setId(person.getId());
        response.setName(person.getName());
        response.setEmail(person.getEmail());
        response.setAge(person.getAge());
        response.setGender(person.getGender());
        response.setProfession(person.getProfession());
        response.setIsAlive(person.getIsAlive());
        return response;
    }
}