package com.santosh.springmongodb.Controller;

import com.santosh.springmongodb.Services.PersonService;
import com.santosh.springmongodb.collections.Person;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/person")
@RequiredArgsConstructor
public class PersonController {

    private final PersonService personService;

    @PostMapping
    public String save(@RequestBody Person person){
      return   personService.save(person);
    }

    @GetMapping
    List<Person> getPersonStartWith(@RequestParam("name")String name){
        return personService.getPersonStartWith(name);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable String id){
        personService.deletePerson(id);
    }

    @GetMapping("/age")
    public List<Person> getPersonByAge(@RequestParam Integer minAge,
                                       @RequestParam Integer maxAge){
       return personService.getPersonByAge(minAge, maxAge);
    }
}
