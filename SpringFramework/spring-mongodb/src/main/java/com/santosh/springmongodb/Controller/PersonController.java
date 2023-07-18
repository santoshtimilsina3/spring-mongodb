package com.santosh.springmongodb.Controller;

import com.santosh.springmongodb.Services.PersonService;
import com.santosh.springmongodb.collections.Person;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/person")
@RequiredArgsConstructor
public class PersonController {

    private final PersonService personService;

    public String save(@RequestBody Person person){
      return   personService.save(person);
    }
}
