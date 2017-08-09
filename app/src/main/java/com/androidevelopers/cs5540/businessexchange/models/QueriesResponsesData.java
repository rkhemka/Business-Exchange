package com.androidevelopers.cs5540.businessexchange.models;

/**
 * Created by rohangoel on 8/6/17.
 */

public class QueriesResponsesData {

    private int professionalId;
    private int userId;
    private String message;


    public QueriesResponsesData() {
    }

    public QueriesResponsesData(int professionalId, int userId, String message, String username) {
        this.professionalId = professionalId;
        this.userId = userId;
        this.message = message;
//        this.username = username;

    }

    public int getProfessionalId() {
        return professionalId;
    }

    public void setProfessionalId(int professionalId) {
        this.professionalId = professionalId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

//    public String getUsername() {
//        return username;
//    }
//
//    public void setUsername(String username) {
//        this.username = username;
//    }
}
