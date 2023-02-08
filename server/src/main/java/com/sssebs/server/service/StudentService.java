package com.sssebs.server.service;

import com.sssebs.server.model.Student;

import java.util.List;
import java.util.Map;
import java.util.Optional;

public interface StudentService {

    List<Student> getAll();
    Optional<Student> getStudent(String studentId);
    void addStudent(Student student);
    void updateStudent(Student student);
    Map<String, Object> getAllStudentInPage(Integer pageNum, Integer pageSize, String sortBy);
    List<Student> getAllByExample(Student student);
}
