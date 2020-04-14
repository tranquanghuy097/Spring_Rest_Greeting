package com.example.demo;

import java.util.concurrent.atomic.AtomicLong;
import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class GreetingController {

    @Autowired
    private GreetingRepo repo;

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    @GetMapping("/greeting")
    public Greeting greeting(@RequestParam(value = "name", defaultValue = "World") String name) {
        return new Greeting(counter.incrementAndGet(), String.format(template, name));
    }

    @GetMapping("/greetings")
    public List<Greeting> getList() {
        return repo.getAllGreetings();
    }

    @GetMapping("/greetings/id")
    public Greeting getByID(@RequestParam(value = "id") Long id){
        return repo.findByID(id);
    }

    @PostMapping("/greetings/add")
    public Greeting add(@RequestBody Greeting newGreeting){
        return repo.save(newGreeting);
    }

    @DeleteMapping("/greetings/delete/id")
    public void delete(@RequestParam(value = "id") Long id){
        repo.delete(id);
    }


}
