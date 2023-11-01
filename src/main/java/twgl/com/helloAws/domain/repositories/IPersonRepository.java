package twgl.com.helloAws.domain.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import twgl.com.helloAws.domain.entities.Person;

@Repository
public interface IPersonRepository extends JpaRepository<Person, Long> { }