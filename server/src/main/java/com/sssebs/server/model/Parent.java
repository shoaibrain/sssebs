package com.sssebs.server.model;

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
    private String middle_name;
    private String last_name;
    private String occupation;
    private Address address;


    public Parent(String parent_id, String first_name,String middle_name, String last_name, Address address, String occupation) {
        this.parent_id = parent_id;
        this.first_name = first_name;
        this.middle_name = middle_name;
        this.last_name = last_name;
        this.address = address;
        this.occupation = occupation;
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

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public List<Student> getStudents() {
        return null;
    }

    public String getOccupation() {
        return occupation;
    }

    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }

    private List<String> students;

}
