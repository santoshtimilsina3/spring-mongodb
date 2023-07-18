package com.santosh.springmongodb.Services;

import com.santosh.springmongodb.Repository.PersonRepository;
import com.santosh.springmongodb.collections.Person;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class PersonServiceImpl implements PersonService{

    private final PersonRepository personRepository;

    @Override
    public String save(Person person) {
      return  personRepository.save(person).getPersonId();
    }
}
