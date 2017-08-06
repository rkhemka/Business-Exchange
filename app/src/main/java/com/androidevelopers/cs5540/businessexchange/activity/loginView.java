package com.androidevelopers.cs5540.businessexchange.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.EditText;

import com.androidevelopers.cs5540.businessexchange.R;

/**
 * Created by rajat on 8/6/2017.
 */

public class loginView extends AppCompatActivity {

    EditText userName;
    EditText passWord;
    Button login;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        userName = (EditText) findViewById(R.id.login_view_editText_UserName);
        passWord = (EditText) findViewById(R.id.login_view_editText_Password);
        login =(Button) findViewById(R.id.login_view_button_login);


    }


}
