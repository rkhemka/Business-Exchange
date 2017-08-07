package com.androidevelopers.cs5540.businessexchange.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.widget.Button;
import android.widget.EditText;

import com.androidevelopers.cs5540.businessexchange.R;

/**
 * Created by rajat on 8/6/2017.
 */

public class contactAskQuery extends AppCompatActivity {

    private EditText userQuery;
    private Button AskQuery;
    private Button CancelQuery;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        userQuery=(EditText) findViewById(R.id.contact_button_enter_userquery);
        AskQuery =(Button) findViewById(R.id.contact_button_ask);
        CancelQuery=(Button) findViewById(R.id.contact_button_cancel);



    }

}
