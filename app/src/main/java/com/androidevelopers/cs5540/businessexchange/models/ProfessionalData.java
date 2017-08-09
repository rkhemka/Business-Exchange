package com.androidevelopers.cs5540.businessexchange.models;

/**
 * Created by rohangoel on 8/4/17.
 */

public class ProfessionalData{

    private String firstName;
    private String lastName;
    private String city;
    private String phone;
    private String emailAddress;
    private String state;
    private String street;
    private String zipCode;
    private String profession;
    private String imageUrl;
    private String description;
    private int id;

    public ProfessionalData(){

    }

    public ProfessionalData(String firstName, String lastName, String city, String phone,
                            String emailAddress, String state, String street, String zipCode,
                            String profession, String imageUrl, int id) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.city = city;
        this.phone = phone;
        this.emailAddress = emailAddress;
        this.state = state;
        this.street = street;
        this.zipCode = zipCode;
        this.profession = profession;
        this.imageUrl=imageUrl;
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailId) {
        this.emailAddress = emailId;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public String getProfession() {
        return profession;
    }

    public void setProfession(String profession) {
        this.profession = profession;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
