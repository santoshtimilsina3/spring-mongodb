package com.santosh.springmongodb.Services;

import com.santosh.springmongodb.collections.Person;

import java.util.List;

public interface PersonService {

    String save(Person person);

    List<Person> getPersonStartWith(String name);

    void deletePerson(String id);

    List<Person> getPersonByAge(Integer minAge, Integer maxAge);
}
