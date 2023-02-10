package com.sssebs.server.controller;

import com.sssebs.server.model.Student;
import com.sssebs.server.service.StudentService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/students")
public class StudentController {
    private static Logger logger = LogManager.getLogger(StudentController.class);
    @Autowired
    private StudentService studentService;

    @RequestMapping("/")
    public List<Student> getAllStudent() {
        List<Student> students = new ArrayList<>();
        try {
            students = studentService.getAll();
        }catch (Exception ex) {
            logger.warn("Failed to get all students", ex);
            ex.printStackTrace();
        }
        return students;
    }


    @RequestMapping(method = RequestMethod.POST, value="/")
    public void addStudent(@RequestBody Student student) {
        try {
            studentService.addStudent(student);
            logger.info("Successfully added new Student");
        } catch (Exception e) {
            logger.warn("Failed to add new student", e);
            e.printStackTrace();
        }

    }

    @RequestMapping(method = RequestMethod.PUT, value = "/")
    public void updateStudent(@RequestBody Student student){
        try {
            studentService.updateStudent(student);
            logger.info("Update Student Information: Success");
        } catch (Exception e) {
            logger.warn("Failed to update Student information", e);
            e.printStackTrace();
        }
    }

    @RequestMapping("/{studentId}")
    public Optional<Student> getStudent(@PathVariable String studentId) {
        try {
            return studentService.getStudent(studentId);
        }catch (Exception e) {
            logger.warn("Student with id {} now found",studentId,e);
            e.printStackTrace();
        }
        return null;
     }

    @RequestMapping("/page")
    public Map<String, Object> getAllStudentInPage(
            @RequestParam(name="pageNum",defaultValue = "0") Integer pageNum,
            @RequestParam(name="pageSize", defaultValue = "2") Integer pageSize,
            @RequestParam(name="sortBy", defaultValue = "student_id") String sortBy) {
        return studentService.getAllStudentInPage(pageNum, pageSize, sortBy);
    }

    @RequestMapping("/example")
    public List<Student> getAllStudentByExample(@RequestBody Student student) {
        return studentService.getAllByExample(student);
    }

}