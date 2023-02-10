package com.sssebs.server.service;

import com.sssebs.server.model.Student;
import com.sssebs.server.repository.StudentRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;


import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class StudentServiceImpl implements StudentService{
    private static Logger logger = LogManager.getLogger(StudentServiceImpl.class);
    @Autowired
    private StudentRepository studentRepository;

    /*
    * returns a list of all students
    * */
    public List<Student> getAll() {
        try {
            return studentRepository.findAll();
        } catch (Exception ex) {
            logger.warn("Failed to get students list", ex);
        }
        return null;

    }

    @Override
    public Optional<Student> getStudent(String studentId) {
        return studentRepository.findById(studentId);
    }

    @Override
    public void addStudent(Student student) {
        try {
            studentRepository.insert(student);
            logger.info("Successfully added new Student");
        } catch (Exception ex) {
            logger.warn("Failed to add new student", ex);
            ex.printStackTrace();
        }
    }

    @Override
    public void updateStudent(Student student) {
        try {
            studentRepository.save(student);
            logger.info("Student Info updated: Success");
        } catch (Exception ex) {
            logger.warn("Failed to update student information");
        }

    }

    @Override
    public Map<String, Object> getAllStudentInPage(Integer pageNum, Integer pageSize, String sortBy) {
        Map<String, Object> response = new HashMap<>();
        try {
            Sort sort = Sort.by(sortBy);
            Pageable page = PageRequest.of(pageNum,pageSize,sort);
            Page<Student> studentPage = studentRepository.findAll(page);
            response.put("data", studentPage.getContent());
            response.put("Total Page",studentPage.getTotalPages());
            response.put("Total Elements", studentPage.getTotalElements());
            response.put("Current Page", studentPage.getNumber());
        } catch (Exception ex) {
            logger.warn("Failed to get Student in Page", ex);
        }
        return response;

    }

    @Override
    public List<Student> getAllByExample(Student student) {
        Example<Student> e = Example.of(student);
        return studentRepository.findAll(e);
    }

}
