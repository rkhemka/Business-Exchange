package com.androidevelopers.cs5540.businessexchange.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.androidevelopers.cs5540.businessexchange.R;
import com.androidevelopers.cs5540.businessexchange.models.ProfessionalData;
import com.google.gson.Gson;
import com.squareup.picasso.Picasso;

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
        Gson gS = new Gson();
        String target = getIntent().getStringExtra("professionalDataObject");
        ProfessionalData professionalData = gS.fromJson(target,ProfessionalData.class);
        professionalImage =(ImageView) findViewById(R.id.professional_image_item_view);
        Name= (TextView) findViewById(R.id.professional_name);
        Profession= (TextView) findViewById(R.id.profession_id_me);
        Street =(TextView) findViewById(R.id.profession_street);
        CityAndZip =(TextView) findViewById(R.id.professional_address_2);
        Contact =(TextView) findViewById(R.id.professional_contact);
        Description=(TextView) findViewById(R.id.professional_description);
        setViewsContent(professionalData);
    }

    public void setViewsContent(ProfessionalData professionalData){
        Name.setText(professionalData.getFirstName()+" "+professionalData.getLastName());
        Profession.setText(professionalData.getProfession());
        Street.setText(professionalData.getStreet());
        CityAndZip.setText(professionalData.getCity()+" ,"+professionalData.getState()+" ,"+professionalData.getZipCode());
        Contact.setText(professionalData.getContact());
        Description.setText(professionalData.getDescription());
        Picasso.with(this)
                .load(professionalData.getImageUrl()).resize(360,300)
                .into(professionalImage);
    }

    public void contactQuery(View view){
        Intent intent = new Intent(this, contactAskQuery.class);
        this.startActivity(intent);
    }
}