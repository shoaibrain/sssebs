package com.sssebs.server.repository;

import com.sssebs.server.model.Student;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface MemberRepository extends MongoRepository<Student, String> {

    @Query("{name:'?0'}")
    Student findStudentByName(String name);

    @Query(value="{category:'?0'}", fields="{'name' : 1, 'quantity' : 1}")
    List<Student> findAll(String category);

    public long count();
}
