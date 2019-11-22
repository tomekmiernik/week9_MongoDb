package com.example.week9.mongoDb.repository;

import com.example.week9.model.RandomUserMongoDb;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepositoryMongoDb extends MongoRepository<RandomUserMongoDb, String> {

}
