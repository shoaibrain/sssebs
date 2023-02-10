package com.sssebs.server.model;

import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Address {

    /*
    * NOTE: This is a generic postal address in context of Nepal
    * */
    private String line1;
    private String line2;
    private String city;
    private String zipCode;
    private String phone; // phone required for some remote address

}
