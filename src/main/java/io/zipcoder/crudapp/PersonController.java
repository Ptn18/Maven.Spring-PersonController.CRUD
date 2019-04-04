package io.zipcoder.crudapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
public class PersonController {
    //Autowired to connect to PersonRepository class
    @Autowired
    private PersonRepository repo;
//Create
// Http is what the response number is
//ResponseEntity contains info for the response. Contains the body and Http status
    @PostMapping(value = "/people")
    public ResponseEntity<Person>create(@RequestBody Person p){
        return new ResponseEntity<>(repo.save(p), HttpStatus.CREATED);
}
//Get
    @GetMapping(value = "/people/{id}")
    public ResponseEntity<Person>show(@PathVariable Long id){
        return new ResponseEntity<>(repo.findById(id).get(), HttpStatus.OK);
}
    @GetMapping(value = "/people")
    public ResponseEntity<List<Person>>getPersonList(){
        return new ResponseEntity<>(repo.findAll(),HttpStatus.OK);
}

//dont need to take in ID bc person should have Id when it comes in
    @PutMapping(value = "/people")
    public ResponseEntity<Person>update(@RequestBody Person p){
        return new ResponseEntity<>(repo.save(p), HttpStatus.OK);
}
    @DeleteMapping(value = "/people/{id}")
    public void destroy(@PathVariable Long id){
//    Person p = repo.findById(id).get();
        repo.deleteById(id);
}
}
