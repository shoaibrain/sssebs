package com.sssebs.server.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Document(collection = "students")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Student extends User{

    private String student_id;
    private String middlename;
    private String dob;
    private Address address;
    private Grade grade;

}