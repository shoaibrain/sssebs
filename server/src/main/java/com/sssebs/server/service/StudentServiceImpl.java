package com.sssebs.server.service;

import com.sssebs.server.collection.Student;
import com.sssebs.server.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService{
    @Autowired
    private StudentRepository studentRepository;
    @Override
    public String save(Student student) {
      return studentRepository.save(student).getStudent_id();
    }
    public List<Student> getAll() {
        return studentRepository.findAll();
    }
}
