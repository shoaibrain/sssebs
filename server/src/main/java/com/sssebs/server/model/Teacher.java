package com.sssebs.server.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("teachers")
public class Teacher implements Employee{
    @Id
    private String teacher_id;
    private String first_name;
    private String last_name;
    private String department;

    public String getTeacher_id() {
        return teacher_id;
    }

    public void setTeacher_id(String teacher_id) {
        this.teacher_id = teacher_id;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public Teacher(String teacher_id, String first_name, String last_name, String department) {
        this.teacher_id = teacher_id;
        this.first_name = first_name;
        this.last_name = last_name;
        this.department = department;
    }
}
