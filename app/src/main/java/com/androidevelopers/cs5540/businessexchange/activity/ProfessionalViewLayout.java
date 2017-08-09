package com.androidevelopers.cs5540.businessexchange.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.androidevelopers.cs5540.businessexchange.BaseActivity;
import com.androidevelopers.cs5540.businessexchange.R;
import com.androidevelopers.cs5540.businessexchange.models.ProfessionalData;
import com.google.gson.Gson;
import com.squareup.picasso.Picasso;

/**
 * Created by rajat on 8/7/2017.
 */

public class ProfessionalViewLayout extends BaseActivity {

    ImageView professionalImage;
    TextView nameTextView;
    TextView professionTextView;
    TextView streetTextView;
    TextView cityStateZipTextView;
    TextView contactTextView;
    TextView descriptionTextView;
    ImageButton contactProfessionalImageButton;
    ProfessionalData professionalData;
    String name;
    String userId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.professional_profile_view);
        Gson gS = new Gson();
        String target = getIntent().getStringExtra("professionalDataObject");
        userId = getIntent().getStringExtra("userId");
        professionalData = gS.fromJson(target,ProfessionalData.class);
        professionalImage =(ImageView) findViewById(R.id.professional_image_item_view);
        nameTextView= (TextView) findViewById(R.id.professional_name);
        professionTextView= (TextView) findViewById(R.id.profession_id_me);
        streetTextView =(TextView) findViewById(R.id.profession_street);
        cityStateZipTextView =(TextView) findViewById(R.id.professional_address_2);
        contactTextView =(TextView) findViewById(R.id.professional_contact);
        descriptionTextView=(TextView) findViewById(R.id.professional_description);
        contactProfessionalImageButton = (ImageButton) findViewById(R.id.contact_professional_image_button);
        setViewsContent(professionalData);
    }

    public void setViewsContent(ProfessionalData professionalData){
        name=getIntent().getStringExtra("name");
        nameTextView.setText(professionalData.getFirstName()+" "+professionalData.getLastName());
        professionTextView.setText(professionalData.getProfession());
        streetTextView.setText(professionalData.getStreet());
        cityStateZipTextView.setText(professionalData.getCity()+" ,"+professionalData.getState()+" ,"+professionalData.getZipCode());
        contactTextView.setText(professionalData.getPhone());
        descriptionTextView.setText(professionalData.getDescription());
        Picasso.with(this)
                .load(professionalData.getImageUrl()).resize(360,300)
                .into(professionalImage);
    }

    public void contactQuery(View view){
//        Intent intent = new Intent(this, ContactAskQuery.class);
//        int professionalId = professionalData.getId();
//        intent.putExtra("userId",userId);
//        intent.putExtra("name",name);
//        intent.putExtra("professionalId", professionalId);
//        this.startActivity(intent);
    }
}