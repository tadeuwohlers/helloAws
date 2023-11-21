package twgl.com.helloAws.application.rest.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import twgl.com.helloAws.domain.dtos.person.CreatePersonDTO;
import twgl.com.helloAws.domain.dtos.person.CreatedPersonDTO;
import twgl.com.helloAws.domain.entities.Person;
import twgl.com.helloAws.domain.services.PersonServices;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/api/v1/person")
public class PersonController {
 
    @Autowired
    PersonServices service;

    @GetMapping
    public List<Person> hello() {
        return service.findAll();
    }

    @PostMapping
    public CreatedPersonDTO postMethodName(@RequestBody CreatePersonDTO entity) {
        return service.create(entity);
    }
}