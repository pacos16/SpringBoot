package com.example.demo.dao;

import com.example.demo.model.Person;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

/*
    DAO stands for Data Acces Object. This is an interface that declares
    the signature of all methods. This helps us to hide the app
    from all the complexitiesnvolved in performing CRUD operations in the underlying storage mechanism.
    This permits both layers to evolve separately without knowing anything about each other.
 */
public interface PersonDao {

    int insertPerson(UUID id, Person person);
    default int insertPerson(Person person){
        UUID id = UUID.randomUUID();
        return insertPerson(id,person);
    }

    List<Person> getAllPeople();

    Optional<Person> getPersonById(UUID id);

    int deletePersonById(UUID id);

    int updatePersonById(UUID id, Person person);

}
