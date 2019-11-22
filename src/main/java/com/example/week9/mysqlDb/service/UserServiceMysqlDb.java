package com.example.week9.mysqlDb.service;

import com.example.week9.aspect.WhatActionTime;
import com.example.week9.model.RandomUserMysqlDb;
import com.example.week9.mysqlDb.repository.UserRepositoryMysql;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceMysqlDb {

    private UserRepositoryMysql userRepositoryMysql;

    @Autowired
    public UserServiceMysqlDb(UserRepositoryMysql userRepositoryMysql) {
        this.userRepositoryMysql = userRepositoryMysql;
    }

    @WhatActionTime
    public void saveUser(RandomUserMysqlDb randomUser) {
        userRepositoryMysql.save(randomUser);
    }

    @WhatActionTime
    public void getAllUsers() {
        userRepositoryMysql.findAll();
    }
}
