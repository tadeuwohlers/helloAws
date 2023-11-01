package twgl.com.helloAws.domain.services;

import java.sql.Timestamp;
import java.time.Instant;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import twgl.com.helloAws.domain.dtos.person.CreatePersonDTO;
import twgl.com.helloAws.domain.dtos.person.CreatedPersonDTO;
import twgl.com.helloAws.domain.entities.Person;
import twgl.com.helloAws.domain.repositories.IPersonRepository;

@Service
public class PersonService {
    
    @Autowired
    IPersonRepository repository;

    @Autowired
    private ModelMapper modelMapper;

    public List<Person> findAll() {
        return repository.findAll();
    }
    
    public CreatedPersonDTO create(CreatePersonDTO newPerson) {

        Person person = modelMapper.map(newPerson, Person.class);
        
        person.setInsertDate(Timestamp.from(Instant.now()));
        person = repository.save(person);
        
        return modelMapper.map(person, CreatedPersonDTO.class);
    }

}