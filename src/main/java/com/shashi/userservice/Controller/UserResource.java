package com.shashi.userservice.Controller;



import com.shashi.userservice.Model.User;
import com.shashi.userservice.Repository.UserRepository;
import com.shashi.userservice.exception.UserNotFoundException;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.logging.Logger;

@RestController
public class UserResource {
    private final static Logger LOGGER = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);
    @Autowired
    private UserRepository repository;
    // Find
    @ApiOperation(value = "Find all the User")
    @GetMapping("/users")
    public List<User> findAll() {
        return repository.findAll();
    }

    @ApiOperation(value = "Register New User")
    @PostMapping("/register")
    //return 201 instead of 200
    @ResponseStatus(HttpStatus.CREATED)
    public User newUser(@RequestBody User newUser) {
        return repository.save(newUser);
    }

    // Find a given user
    @ApiOperation(value = "Find User by Id ")
    @GetMapping("/users/{id}")
    public User findOne(@PathVariable int id) {
        LOGGER.info("/users/{id} called with id "+ id);
        // Optional<User> user = repository.findById(id);
        return repository.findById(id)
                .orElseThrow(() -> new UserNotFoundException(id));

    }

    @ApiOperation(value = "Find User by Id ")
    @GetMapping("/usersByName/{name}")
    public User findUserByName(@PathVariable String name) {
        LOGGER.info("/users/{name} called with name "+ name);
        // Optional<User> user = repository.findById(id);
        return repository.findUserByName(name);
    }
}
