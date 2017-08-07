package com.androidevelopers.cs5540.businessexchange.models;

/**
 * Created by rohangoel on 8/7/17.
 */

public class UserData {

    private String firstName;
    private String lastName;
    private String contact;
    private String emailAddress;
    private int id;

    public UserData() {
    }

    public UserData(String firstName, String lastName, String contact, String emailAddress, int id) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.contact = contact;
        this.emailAddress = emailAddress;
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

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
