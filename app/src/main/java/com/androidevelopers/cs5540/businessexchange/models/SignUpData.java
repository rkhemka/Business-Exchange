package com.androidevelopers.cs5540.businessexchange.models;

/**
 * Created by rajat on 8/6/2017.
 */

public class SignUpData {

    private Integer id;
    private String avatar;
    private String firstName;
    private String lastName;
    private String city;
    private String contact;
    private String emailId;
    private String profession;
    private String state;
    private String street;
    private String zipCode;

    public SignUpData(){}

    public SignUpData(Integer id, String avatar, String firstName,String lastName, String city, String contact,String emailId, String profession, String state,String street,String zipCode ){
        setId(id);
        setAvatar(avatar);
        setFirstName(firstName);
        setLastName(lastName);
        setCity(city);
        setContact(contact);
        setEmailId(emailId);
        setProfession(profession);
        setState(state);
        setStreet(street);
        setZipCode(zipCode);
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
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

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public String getProfession() {
        return profession;
    }

    public void setProfession(String profession) {
        this.profession = profession;
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
}
