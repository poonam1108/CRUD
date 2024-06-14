package com.example.demo.service.impl;

import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.UserServiceI;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserServiceI {

    Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);


    @Autowired UserRepository userRepository;

    @Override
    public User createUser(User user) {
        logger.info("Entering into createUser method of UserServiceImpl Class");
        User savedUser = userRepository.save(user);
        logger.info("Completed the createUser method of UserServiceImpl Class");
        return savedUser;
    }

    @Override
    public User updateUser(User user, Long userId) {
        logger.info("Entering into updateUser method of UserServiceImpl Class with userId: {}",userId);
        User user1 = userRepository.findById(userId).get();
        user1.setUserName(user.getUserName());
        user1.setUserAge(user.getUserAge());
        user1.setAbout(user.getAbout());

        User updatedUser = userRepository.save(user1);
        logger.info("Completed the updateUser method of UserServiceImpl Class with userId: {}",userId);
        return updatedUser;
    }

    @Override
    public User getSingleUser(Long userId) throws Exception{

//        User user = userRepository.findById(userId)
//                .orElseThrow(() -> new RuntimeException("Resource not found on server"));
//        return user;


        logger.info("Entering the getSingleUser method of UserServiceImpl Class with userId: {} ",userId);

        Optional<User> user = userRepository.findById(userId);
        if(user.isPresent())
        {
            logger.info("Completed the getSingleUser method of UserServiceImpl Class with userId: {} ",userId);
            return user.get();
        }
        else
        {
            throw new Exception("Resource not found on server ,userId: "+userId);
        }


    }


    @Override
    public List<User> getAllUsers() {
        logger.info("Entering into getAllUsers method of UserServiceImpl class");
        List<User> allUsers = userRepository.findAll();
        logger.info("Completed the getAllUsers method of UserServiceImpl class");
        return allUsers;

    }

    @Override
    public void deleteUser(Long userId) {
        logger.info("Entering into deleteUser method of UserServiceImpl Class with userId: {} ",userId);
        User user = userRepository.findById(userId).orElseThrow(() -> new RuntimeException("Resource not found on server"));
        logger.info("Completed the deleteUsers method of UserServiceImpl Class with userId: {} ",userId);
        userRepository.delete(user);
    }
}
