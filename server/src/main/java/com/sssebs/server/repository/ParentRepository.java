package com.sssebs.server.repository;

import com.sssebs.server.model.Parent;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ParentRepository extends MongoRepository<Parent, String> {
}
