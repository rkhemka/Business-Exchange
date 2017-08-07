package com.androidevelopers.cs5540.businessexchange.models;

/**
 * Created by rohangoel on 8/6/17.
 */

public class ProfessionalMessage {

    private int professionalId;
    private int userId;
    private String message;

    public ProfessionalMessage() {
    }

    public ProfessionalMessage(int professionalId, int userId, String message) {
        this.professionalId = professionalId;
        this.userId = userId;
        this.message = message;
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
}
