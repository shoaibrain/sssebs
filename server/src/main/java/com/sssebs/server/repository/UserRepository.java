package com.sssebs.server.repository;

import com.sssebs.server.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends MongoRepository<User,Integer> {

    //find user by its email
    Optional<User> findByEmail(String email);
    List<User> findAll();
}
