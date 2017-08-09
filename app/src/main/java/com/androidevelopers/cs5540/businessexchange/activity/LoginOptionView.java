package com.androidevelopers.cs5540.businessexchange.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import com.androidevelopers.cs5540.businessexchange.R;

/**
 * Created by rajat on 8/6/2017.
 */

public class LoginOptionView extends AppCompatActivity{

    ImageView professionalLoginImageView;
    ImageView userLoginImageView;
    Context context;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_option_view);
        professionalLoginImageView = (ImageView) findViewById(R.id.professional_login_image_view);
        userLoginImageView = (ImageView) findViewById((R.id.user_login_image_view));
        context=this;
    }

    public void selectLogin(View view){
        String selectedId= view.getTag().toString();
        Log.d("selected tag: ",selectedId);
            Intent intent = new Intent(this.context,LoginView.class);
            intent.putExtra("selectedId", Integer.parseInt(selectedId));
            context.startActivity(intent);
        }
    }

