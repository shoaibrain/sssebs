package com.sssebs.server.repository;

import com.sssebs.server.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface UserRepository extends MongoRepository<User,String> {

    //find user by its email
    Optional<User> findByEmail(String email);
}
