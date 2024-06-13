package com.example.demo.service.impl;

import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.UserServiceI;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class UserServiceImpl implements UserServiceI {

    @Autowired UserRepository userRepository;

    @Override
    public User createUser(User user) {
        User savedUser = userRepository.save(user);
        return savedUser;
    }

    @Override
    public User updateUser(User user, Long userId) {

        User user1 = userRepository.findById(userId).get();
        user1.setUserName(user.getUserName());
        user1.setUserAge(user.getUserAge());
        user1.setAbout(user.getAbout());

        User updatedUser = userRepository.save(user1);
        return updatedUser;
    }

    @Override
    public User getSingleUser(Long userId) throws Exception{

        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("Resource not found on server"));
        return user;


//        Optional<User> user = userRepository.findById(userId);
//        if(user.isPresent())
//        {
//            return user.get();
//        }
//        else
//        {
//            throw new Exception("Resource not found on server ,userId: "+userId);
//        }



    }


    @Override
    public List<User> getAllUsers() {
        List<User> allUsers = userRepository.findAll();
        return allUsers;

    }



    @Override
    public void deleteUser(Long userId) {

        User user = userRepository.findById(userId).orElseThrow(() -> new RuntimeException("Resource not found on server"));
        userRepository.delete(user);
    }
}
