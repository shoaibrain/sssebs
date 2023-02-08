package com.sssebs.server.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "students")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Student {
    @Id
    private String student_id;
    private String parent_id; // for relational mapping later
    private String first_name;
    private String middle_name;
    private String last_name;
    private String dob;
    private Address address;
    private Grade grade;

    public Student(String student_id, String parent_id, String first_name,String middle_name, String last_name, String dob, Grade grade, Address address) {
        this.student_id = student_id;
        this.parent_id = parent_id;
        this.first_name = first_name;
        this.middle_name = middle_name;
        this.last_name = last_name;
        this.dob = dob;
        this.grade = grade;
        this.address = address;
    }

    public String getStudent_id() {
        return student_id;
    }

    public void setStudent_id(String student_id) {
        this.student_id = student_id;
    }

    public String getParent_id() {
        return parent_id;
    }

    public void setParent_id(String parent_id) {
        this.parent_id = parent_id;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getMiddle_name() {
        return middle_name;
    }

    public void setMiddle_name(String middle_name) {
        this.middle_name = middle_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public Grade getGrade() {
        return grade;
    }

    public void setGrade(Grade grade) {
        this.grade = grade;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

}