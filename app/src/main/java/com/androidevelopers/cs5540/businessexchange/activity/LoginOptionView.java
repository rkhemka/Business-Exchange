package com.androidevelopers.cs5540.businessexchange.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
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
    public void onCreate(@Nullable Bundle savedInstanceState, @Nullable PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);
        professionalLoginImageView = (ImageView) findViewById(R.id.professional_login_image_view);
        userLoginImageView = (ImageView) findViewById((R.id.user_login_image_view));
        context=this;
    }

    public void selectLogin(View view){
        int selectedId = (int) view.getTag();
            Intent intent = new Intent(this.context,LoginView.class);
            intent.putExtra("selectedId", selectedId);
            context.startActivity(intent);
        }
    }

