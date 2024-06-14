package com.example.demo.controller;

import com.example.demo.model.User;
import com.example.demo.service.UserServiceI;
import com.example.demo.service.impl.UserServiceImpl;
import org.apache.coyote.Request;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class UserController {

    Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserServiceI userServiceI;

    // @RequestMapping(method = RequestMethod.POST,name="/users")
   @PostMapping("/users")
    public ResponseEntity<User> createUser(@RequestBody User user)
    {
        logger.info("Entering into the createUser method of UserController class");
        User savedUser = userServiceI.createUser(user);
        logger.info("Completed the createUser method of UserController class");
        return new ResponseEntity<>(savedUser, HttpStatus.CREATED);
    }

    @GetMapping("/users")
    public ResponseEntity<List<User>> getAllUsers()
    {
        logger.info("Entering into the getAllUsers method of UserController class");
        List<User> allUsers = userServiceI.getAllUsers();
        logger.info("Completed the getAllUsers method of UserController class");
        return new ResponseEntity<>(allUsers, HttpStatus.OK);
    }

    @GetMapping("/users/{userId}")
    public ResponseEntity<User> getSingleUser(@PathVariable Long userId) throws Exception
    {
        logger.info("Entering the getSingleUser method with userId: {} ",userId);
        User user = userServiceI.getSingleUser(userId);
        logger.info("Completed the getSingleUser method with userId: {} ",userId);
        return new ResponseEntity<>(user, HttpStatus.OK);

    }

    @PutMapping("/users/{userId}")
    public ResponseEntity<User> updateUser(@RequestBody User user, @PathVariable Long userId)
    {
        logger.info("Entering the updateUser method with userId: {} ",userId);
        User updatedUser = userServiceI.updateUser(user,userId);
        logger.info("Completed the updateUser method with userId: {} ",userId);
        return new ResponseEntity<>(updatedUser, HttpStatus.CREATED);

    }

    @DeleteMapping("/users/{userId}")
    public ResponseEntity<String> deleteUser(@PathVariable Long userId)
    {
        logger.info("Entering the deleteUser method with userId: {} ",userId);
        userServiceI.deleteUser(userId);
        logger.info("Completed the deleteUser method with userId: {} ",userId);
        return new ResponseEntity<>("Resource deleted successfully", HttpStatus.OK);

    }


}
