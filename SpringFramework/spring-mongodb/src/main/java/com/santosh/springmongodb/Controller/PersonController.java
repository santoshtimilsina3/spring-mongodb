package com.santosh.springmongodb.Controller;

import com.santosh.springmongodb.Services.PersonService;
import com.santosh.springmongodb.collections.Person;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PagedResourcesAssembler;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/person")
@RequiredArgsConstructor
public class PersonController {

    private final PersonService personService;

    @PostMapping
    public String save(@RequestBody Person person) {
        return personService.save(person);
    }

    @GetMapping
    List<Person> getPersonStartWith(@RequestParam("name") String name) {
        return personService.getPersonStartWith(name);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable String id) {
        personService.deletePerson(id);
    }

    @GetMapping("/age")
    public List<Person> getPersonByAge(@RequestParam Integer minAge,
                                       @RequestParam Integer maxAge) {
        return personService.getPersonByAge(minAge, maxAge);
    }

    @GetMapping("/search")
    public Page<Person> searchPerson(@RequestParam(required = false) String name,
                                     @RequestParam(required = false) Integer minAge,
                                     @RequestParam(required = false) Integer maxAge,
                                     @RequestParam(required = false) String city,
                                     @RequestParam(defaultValue = "0") Integer page,
                                     @RequestParam(defaultValue = "5") Integer size) {
        {
            Pageable pageable = PageRequest.of(page,size);
            return personService.search(name,minAge,maxAge,city,pageable);
        }

        }
    }
