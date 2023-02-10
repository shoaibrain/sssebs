package com.sssebs.server.model;

public class Address {

    /*
    * NOTE: This is a generic postal address in context of Nepal
    * */
    private String line1;
    private String line2;
    private String city;
    private String zipCode;
    private String phone; // phone required for some remote address

    public Address(String line1, String line2, String city, String zipCode, String phone) {
        this.line1 = line1;
        this.line2 = line2;
        this.city = city;
        this.zipCode = zipCode;
        this.phone = phone;
    }

    public String getLine1() {
        return line1;
    }

    public void setLine1(String line1) {
        this.line1 = line1;
    }

    public String getLine2() {
        return line2;
    }

    public void setLine2(String line2) {
        this.line2 = line2;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
