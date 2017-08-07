package com.androidevelopers.cs5540.businessexchange;

import android.content.Context;
import android.support.v4.app.LoaderManager;
import android.support.v4.content.AsyncTaskLoader;
import android.support.v4.content.Loader;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;

import com.androidevelopers.cs5540.businessexchange.models.ProfessionalData;
import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.client.ValueEventListener;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements LoaderManager.LoaderCallbacks<Void> {

    private ProgressBar progressBar;
    private RecyclerView recyclerView;
    private RecyclerView.Adapter userDashboardAdapter;
    private RecyclerView.LayoutManager layoutManager;
    private ImageView mainScreenImage;
    private Firebase mRef;
    ArrayList<ProfessionalData> professionals = new ArrayList<ProfessionalData>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        progressBar=(ProgressBar) findViewById(R.id.progressBar);
        recyclerView = (RecyclerView) findViewById(R.id.user_dashboard_recycler);
        mRef = new Firebase("https://business-exchange-8a152.firebaseio.com/professionals_details");
    }

    public Loader<Void> onCreateLoader(int id, final Bundle args) {
        return new AsyncTaskLoader<Void>(this) {

            @Override
            protected void onStartLoading() {
                super.onStartLoading();
                progressBar.setVisibility(View.VISIBLE);
            }
            @Override
            public Void loadInBackground() {
                mRef.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        for (DataSnapshot ds : dataSnapshot.getChildren()) {
                            ProfessionalData professionalData = ds.getValue(ProfessionalData.class);
                            professionals.add(professionalData);
                        }
                        Log.i("data from array list: ", professionals.get(0).getFirstName());
                    }
                    @Override
                    public void onCancelled(FirebaseError firebaseError) {
                    }
                });
                return null;
            }
        };
    }

    @Override
    public void onLoadFinished(Loader<Void> loader, Void data) {
        progressBar.setVisibility(View.GONE);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(userDashboardAdapter);

    }

    @Override
    public void onLoaderReset(Loader<Void> loader) {
    }


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
}