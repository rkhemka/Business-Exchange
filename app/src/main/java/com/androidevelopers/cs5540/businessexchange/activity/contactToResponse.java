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

public class contactToResponse extends AppCompatActivity {

    private RecyclerView recyclerView;
    private EditText responseToUserQuery;
    private Button responseToReply;
    private Button responseToCancel;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        recyclerView= (RecyclerView) findViewById(R.id.recyclerViewOfContactToResponse);
        responseToUserQuery= (EditText) findViewById(R.id.response_to_edit_reply);
        responseToReply=(Button) findViewById(R.id.button_response_to_reply);
        responseToCancel= (Button) findViewById(R.id.button_response_to_cancel);
    }
}
