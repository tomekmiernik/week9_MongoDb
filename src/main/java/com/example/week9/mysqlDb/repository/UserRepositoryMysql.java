package com.example.week9.mysqlDb.repository;

import com.example.week9.model.RandomUserMysqlDb;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepositoryMysql extends JpaRepository<RandomUserMysqlDb, Long> {

}
