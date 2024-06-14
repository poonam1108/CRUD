package com.example.demo.controller;

import com.example.demo.model.User;
import com.example.demo.service.UserServiceI;
import com.example.demo.service.impl.UserServiceImpl;
import org.apache.coyote.Request;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class UserController {

    @Autowired
    private UserServiceI userServiceI;

    // @RequestMapping(method = RequestMethod.POST,name="/users")
   @PostMapping("/users")
    public ResponseEntity<User> createUser(@RequestBody User user)
    {
        User savedUser = userServiceI.createUser(user);
        return new ResponseEntity<>(savedUser, HttpStatus.CREATED);
    }

    @GetMapping("/users")
    public ResponseEntity<List<User>> getAllUsers()
    {
        List<User> allUsers = userServiceI.getAllUsers();
        return new ResponseEntity<>(allUsers, HttpStatus.OK);
    }

    @GetMapping("/users/{userId}")
    public ResponseEntity<User> getSingleUser(@PathVariable Long userId) throws Exception {
        User user = userServiceI.getSingleUser(userId);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @PutMapping("/users/{userId}")
    public ResponseEntity<User> updateUser(@RequestBody User user, @PathVariable Long userId)
    {
        User updatedUser = userServiceI.updateUser(user,userId);
        return new ResponseEntity<>(updatedUser, HttpStatus.CREATED);

    }

    @DeleteMapping("/users/{userId}")
    public ResponseEntity<String> deleteUser(@PathVariable Long userId)
    {
        userServiceI.deleteUser(userId);
        return new ResponseEntity<>("Resource deleted successfully", HttpStatus.OK);

    }


}
