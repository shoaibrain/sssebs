package com.sssebs.server.controller;

import com.sssebs.server.model.Student;
import com.sssebs.server.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/students")
public class StudentController {

    @Autowired
    private StudentService studentService;

//    @RequestMapping("/")
//    public List<Student> getAllStudent() {
//    return studentService.getAll();
//    }

    @GetMapping
    public ResponseEntity<String> sayHello () {
        return ResponseEntity.ok("Hello from secured endpoint");
    }

    @RequestMapping(method = RequestMethod.POST, value="/")
    public void addStudent(@RequestBody Student student) {
        studentService.addStudent(student);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/")
    public void updateStudent(@RequestBody Student student){
        studentService.updateStudent(student);
    }

    @RequestMapping("/{studentId}")
    public Optional<Student> getStudent(@PathVariable String studentId) {
        return studentService.getStudent(studentId);
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