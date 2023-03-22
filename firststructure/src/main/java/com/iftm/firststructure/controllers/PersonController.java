package com.iftm.firststructure.controllers;

import com.iftm.firststructure.models.Person;
import com.iftm.firststructure.services.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api")
public class PersonController {

    // Injecao de dependencias
    @Autowired
    private PersonService personService;

    //CRUD
    // READ - HTTP GET
    // http://localhost:8080/api/persons
    @GetMapping("persons")
    public List<Person> findAll() {
        return personService.findAll();
    }

    // http://localhost:8080/api/person/ID
    @GetMapping("person/{id}")
    public Optional<Person> find(@PathVariable("id") Long id) {
        return personService.findById(id);
    }

    // CREATE - HPPT POST
    // http://localhost:8080/api/person
    //{
    //    "firstName": "Camilo",
    //    "lastName": "Barreto",
    //    "age": 31,
    //    "address": "iftm"
    //}
    @PostMapping("person")
    public Person save(@RequestBody Person person) {
        return personService.save(person);
    }

    // UPDATE - HTTP PUT
    //{
    //    "id": 1
    //    "firstName": "Camilo",
    //    "lastName": "Barreto",
    //    "age": 31,
    //    "address": "iftm"
    //}
    @PutMapping("person")
    public Person update(@RequestBody Person person) {
        return personService.update(person);
    }

    // DELETE - HTTP DELETE
    @DeleteMapping("person/{id}")
    public String delete(@PathVariable("id") Long id) {
        return personService.delete(id);
    }
}
