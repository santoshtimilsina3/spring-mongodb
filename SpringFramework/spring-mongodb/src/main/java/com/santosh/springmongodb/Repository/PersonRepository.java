package com.santosh.springmongodb.Repository;

import com.santosh.springmongodb.collections.Person;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PersonRepository extends MongoRepository<Person,String> {

 List<Person> findByFirstNameStartsWith(String name);

}
