package com.sssebs.server.service;

import com.sssebs.server.collection.Student;

import java.util.List;

public interface StudentService {
    String save(Student student);


    List<Student> getAll();
}
