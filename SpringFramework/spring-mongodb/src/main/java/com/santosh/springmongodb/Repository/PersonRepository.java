package com.santosh.springmongodb.Repository;

import com.santosh.springmongodb.collections.Person;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PersonRepository extends MongoRepository<Person, String> {

    List<Person> findByFirstNameStartsWith(String name);

    @Query(value = "{'age': { $gt : ?0, $lt : ?1}}"
            ,fields = "{address: 0}" // THis means we dont need to fetch address field
    )
    List<Person> findPersonByAgeBetween(Integer minAge, Integer maxAge);

    Page<Person> search(String name, Integer minAge, Integer maxAge, String city, Pageable pageable);
}
