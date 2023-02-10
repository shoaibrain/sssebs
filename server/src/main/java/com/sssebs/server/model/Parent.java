package com.sssebs.server.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Document(collection = "parents")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Parent extends User{

    private String parent_id;
    private String middlename;
    private String occupation;
    private Address address;

}
