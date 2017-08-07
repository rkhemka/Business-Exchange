package com.androidevelopers.cs5540.businessexchange.models;

/**
 * Created by rajat on 8/6/2017.
 */

public class LoginData {

    private String userName;
    private String passWord;
    private Integer id;
    public LoginData(){

    }
    public LoginData(Integer id,String userName, String passWord ){
        this.id = id;
        this.userName= userName;
        this.passWord =passWord;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }
}
