package challenge.apidemo.rest;

import challenge.apidemo.registration.model.Person;
import challenge.apidemo.registration.model.PersonModel;
import challenge.apidemo.registration.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(value = "/api/people", produces = "application/hal+json")
public class PersonController {

    @Autowired
    private PersonRepository personRepository;

    @GetMapping("/{id}")
    public ResponseEntity<Person> getPerson(@PathVariable final long id) {
        Person p = personRepository.findById(id).get();
        return new ResponseEntity<>(p, HttpStatus.OK);

    }

    @GetMapping
    public ResponseEntity<List<Person>> all() {
        List<Person> person = personRepository.findAll();
        return new ResponseEntity<>(person, HttpStatus.OK);

    }

    @PostMapping
    public ResponseEntity<Person> post(@Valid @RequestBody final PersonModel requestPerson) {
        Person newPerson = new Person(requestPerson);
        final Person person = personRepository.save(newPerson);
        return new ResponseEntity<>(person, HttpStatus.CREATED);
    }

    @PostMapping
    public ResponseEntity<Person> put(@Valid @RequestBody final PersonModel requestPerson) {
        Person updatedPerson = new Person(requestPerson);
        final Person person = personRepository.save(updatedPerson);
        return new ResponseEntity<>(person, HttpStatus.CREATED);
    }
}
