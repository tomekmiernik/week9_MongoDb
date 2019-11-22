package com.example.week9.mongoDb.service;

import com.example.week9.aspect.WhatActionTime;
import com.example.week9.model.RandomUserMongoDb;
import com.example.week9.mongoDb.repository.UserRepositoryMongoDb;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceMongoDb {

    private UserRepositoryMongoDb userRepository;

    @Autowired
    public UserServiceMongoDb(UserRepositoryMongoDb userRepository) {
        this.userRepository = userRepository;
    }

    @WhatActionTime
    public void saveUser(RandomUserMongoDb randomUser){
        userRepository.save(randomUser);
    }

    @WhatActionTime
    public void getAllUsers(){
        userRepository.findAll();
    }
}
