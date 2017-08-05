package com.androidevelopers.cs5540.businessexchange;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageView;

import com.androidevelopers.cs5540.businessexchange.Adapters.UserDashboardAdpater;
import com.androidevelopers.cs5540.businessexchange.models.ProfessionalData;
import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.client.ValueEventListener;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    RecyclerView.Adapter adapter;
    RecyclerView.LayoutManager layoutManager;
    private Button addDataButton;
    private Button fetchDataButton;
    private ImageView mainScreenImage;
    private Firebase mRef;
    ArrayList<ProfessionalData> professionals = new ArrayList<ProfessionalData>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        addDataButton =(Button) findViewById(R.id.add_data_button);
//        fetchDataButton = (Button) findViewById(R.id.fetch_data_button);
        mainScreenImage = (ImageView) findViewById(R.id.main_screen_image);
        mainScreenImage.animate().alpha(0).setDuration(10000);

        mRef = new Firebase("https://business-exchange-8a152.firebaseio.com/professionals_details");

//        addDataButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Firebase mRefChild = mRef.child("Name");
//                mRefChild.setValue("Rohan");
//            }
//        });

        mRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for (DataSnapshot ds : dataSnapshot.getChildren()) {
                    ProfessionalData professionalData = ds.getValue(ProfessionalData.class);
                    professionals.add(professionalData);
                    Log.i("---------firstname", professionalData.getFirstName());
                }
            }
            @Override
            public void onCancelled(FirebaseError firebaseError) {

            }
        });


//    Inflate in Profession Activity
//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        getMenuInflater().inflate(R.menu.menu, menu);
//
//        MenuItem item = menu.findItem(R.id.categoryMenuItem);
//        Spinner spinner = (Spinner) MenuItemCompat.getActionView(item);
//        spinner.setOnItemSelectedListener(this);
//
//        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
//                R.array.professions,
//                android.R.layout.simple_spinner_item);
//        adapter.setDropDownViewResource(
//                android.R.layout.simple_spinner_dropdown_item);
//
//        spinner.setAdapter(adapter);
//        return true;
//    }
//
//    @Override
//    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
//
//    }
//
//    @Override
//    public void onNothingSelected(AdapterView<?> adapterView) {
//
//    }

        recyclerView = (RecyclerView) findViewById(R.id.user_dashboard_recycler);
        adapter = new UserDashboardAdpater(professionals, this);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);

    }




}