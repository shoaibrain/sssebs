package com.sssebs.server.collection;

import com.fasterxml.jackson.annotation.JsonInclude;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document(collection = "parents")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Parent {

    @Id
    private String parent_id;
    private String first_name;
    private String last_name;

    public Parent(String parent_id, String first_name, String last_name) {
        this.parent_id = parent_id;
        this.first_name = first_name;
        this.last_name = last_name;
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

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public List<Student> getStudents() {
        return null;
    }

    private List<String> students;

}
