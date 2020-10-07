package com.example.demo.dao;

import com.example.demo.model.Person;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
/*
. A repository is a mechanism for encapsulating storage, retrieval, and search behavior
 which emulates a collection of objects.
 It is a specialization of the @Component annotation allowing for implementation classes to be
 autodetected through classpath scanning.
 */
@Repository("fakeDao")
public class FakePersonDataAccessService implements PersonDao{

    private static List<Person> dB =new ArrayList<>();
    @Override
    public int insertPerson(UUID id, Person person) {
        dB.add(new Person(id,person.getName()));
        return 1;
    }

    @Override
    public List<Person> getAllPeople() {
        return dB;
    }

    @Override
    public Optional<Person> getPersonById(UUID id) {
         return dB.stream()
                 .filter(person -> person.getId().equals(id))
                 .findFirst();
    }

    @Override
    public int deletePersonById(UUID id) {

        Optional<Person> person =getPersonById(id);
        if(person.isPresent()){
            dB.remove(person.get());
            return 1;
        }
        return 0;
    }

    @Override
    public int updatePersonById(UUID id, Person person) {
        return getPersonById(id)
                .map(person1 -> {
                    int indexOfPersonToUpdate =dB.indexOf(person1);
                    if(indexOfPersonToUpdate>=0){
                        dB.set(indexOfPersonToUpdate,new Person(id, person.getName()));
                        return 1;
                    }
                 return 0;
                })
                .orElse(0);
    }
}
