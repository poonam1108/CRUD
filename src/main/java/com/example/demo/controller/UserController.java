package com.example.demo.controller;

import com.example.demo.model.User;
import com.example.demo.service.UserServiceI;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//@RestController
@Controller
@RequestMapping("/api")
public class UserController {

    private UserServiceI userServiceI;


    @PostMapping("/")
    public ResponseEntity<User> createUser()
    {

        return null;
    }


}
