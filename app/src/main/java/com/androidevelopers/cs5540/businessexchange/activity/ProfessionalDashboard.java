package com.androidevelopers.cs5540.businessexchange.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.LoaderManager;
import android.support.v4.content.AsyncTaskLoader;
import android.support.v4.content.Loader;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.androidevelopers.cs5540.businessexchange.BaseActivity;
import com.androidevelopers.cs5540.businessexchange.R;
import com.androidevelopers.cs5540.businessexchange.adapters.ProfessionalDashboardAdpater;
import com.androidevelopers.cs5540.businessexchange.dbUtils.FirebaseHelper;
import com.androidevelopers.cs5540.businessexchange.firebase.database.FirebaseUrls;
import com.androidevelopers.cs5540.businessexchange.models.QueriesResponsesData;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

/**
 * Created by rohangoel on 8/6/17.
 */

public class ProfessionalDashboard extends BaseActivity implements LoaderManager.LoaderCallbacks<Void>, ProfessionalDashboardAdpater.ProfessionalDashboardItemClickListener{
    private ProgressBar progressBar;
    private RecyclerView recyclerView;
    private RecyclerView.Adapter professionalDashboardAdapter;
    private RecyclerView.LayoutManager layoutManager;
    private TextView noMessageTextView;
    private FirebaseHelper firebaseHelper;
    private DatabaseReference db;
    private String name;
    ArrayList<QueriesResponsesData> queries = new ArrayList<QueriesResponsesData>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.professional_dashboard_view);
        progressBar=(ProgressBar) findViewById(R.id.professional_dashboard_progressBar);
        recyclerView = (RecyclerView) findViewById(R.id.messages_recycler_view);
        db = FirebaseDatabase.getInstance().getReferenceFromUrl(FirebaseUrls.BASE_URL);
        firebaseHelper = new FirebaseHelper(db);
        noMessageTextView = (TextView) findViewById(R.id.no_message_text_view);
        name=getIntent().getStringExtra("name");

    }

    @Override
    public Loader<Void> onCreateLoader(int id, Bundle args) {
        return new AsyncTaskLoader<Void>(this) {

            @Override
            protected void onStartLoading() {
                super.onStartLoading();
                progressBar.setVisibility(View.VISIBLE);
            }
            @Override
            public Void loadInBackground() {
         //       queries = firebaseHelper.retrieveProfessionalMessagesList();
                return null;
            }
        };
    }

    @Override
    public void onLoadFinished(Loader<Void> loader, Void data) {
        if(queries.size()!=0) {
            noMessageTextView.setVisibility(View.INVISIBLE);
            professionalDashboardAdapter = new ProfessionalDashboardAdpater(queries,this,this);
            layoutManager = new LinearLayoutManager(this);
            recyclerView.setHasFixedSize(true);
            recyclerView.setLayoutManager(layoutManager);
            recyclerView.setAdapter(professionalDashboardAdapter);
            recyclerView.setVisibility(View.VISIBLE);
        }
        else{
            noMessageTextView.setVisibility(View.VISIBLE);
            recyclerView.setVisibility(View.INVISIBLE);
        }
    }

    @Override
    public void onLoaderReset(Loader<Void> loader) {

    }

    @Override
    public void onItemClick(int clickedItemIndex) {
//        Intent intent = new Intent(this, ContactToResponse.class);
//        intent.putExtra("userId",queries.get(clickedItemIndex).getUserId());
//        intent.putExtra("name",name);
//        intent.putExtra("professionalId", queries.get(clickedItemIndex).getProfessionalId());
//        this.startActivity(intent);
    }
}
