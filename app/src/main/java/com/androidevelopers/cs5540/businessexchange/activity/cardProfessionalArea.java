package com.androidevelopers.cs5540.businessexchange.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;

import com.androidevelopers.cs5540.businessexchange.R;

/**
 * Created by rajat on 8/6/2017.
 */

public class cardProfessionalArea extends AppCompatActivity {

    private TextView textView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        textView= (TextView) findViewById(R.id.txt_name);

    }

}
