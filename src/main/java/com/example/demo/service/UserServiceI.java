package com.example.demo.service;

import com.example.demo.model.User;

import java.util.List;

public interface UserServiceI {

   User createUser(User user);

   User updateUser(User user, Long userId);

   User getSingleUser(Long userId);

   List<User> getAllUsers();

   void deleteUser(Long userId);

}
