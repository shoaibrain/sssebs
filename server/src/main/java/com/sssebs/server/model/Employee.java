package com.sssebs.server.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Document(collection = "employees")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Employee extends User{

    private String employee_id;
    private String middlename;
    private String dob;
    private Address address;
    private EmployeeType empType;

}
