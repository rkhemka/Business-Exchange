package com.androidevelopers.cs5540.businessexchange.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.androidevelopers.cs5540.businessexchange.R;

/**
 * Created by rajat on 8/6/2017.
 */

public class ContactAskQuery extends AppCompatActivity {

    private EditText userQueryEditText;
    private Button askQueryButton;
    private Button cancelQueryButton;
    private String query;
    private int professionalId;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        professionalId = getIntent().getIntExtra("professionalId",-1);
        userQueryEditText= (EditText) findViewById(R.id.contact_button_enter_userquery);
        askQueryButton = (Button) findViewById(R.id.contact_button_ask);
        cancelQueryButton= (Button) findViewById(R.id.contact_button_cancel);
    }

    public void cancelQuery(View view){
        Intent intent = new Intent(this, ProfessionalViewLayout.class);
        this.startActivity(intent);
    }
    public void sendQuery(View view) {
        query=userQueryEditText.getText().toString();

    }

}
