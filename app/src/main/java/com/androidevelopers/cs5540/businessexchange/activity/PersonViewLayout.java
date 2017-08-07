package com.androidevelopers.cs5540.businessexchange.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.androidevelopers.cs5540.businessexchange.R;

/**
 * Created by rajat on 8/7/2017.
 */

public class PersonViewLayout extends AppCompatActivity {

    ImageView professionalImage;
    TextView Name;
    TextView Profession;
    TextView Street;
    TextView CityAndZip;
    TextView Contact;
    TextView Description;
    ImageButton contactProfessional;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        professionalImage =(ImageView) findViewById(R.id.professional_image_item_view);
        Name= (TextView) findViewById(R.id.professional_name);
        Profession= (TextView) findViewById(R.id.profession_id_me);
        Street =(TextView) findViewById(R.id.profession_street);
        CityAndZip =(TextView) findViewById(R.id.professional_address_2);
        Contact =(TextView) findViewById(R.id.professional_contact);
        Description=(TextView) findViewById(R.id.professional_description);



    }
}
