package com.androidevelopers.cs5540.businessexchange.firebase.database;

import android.util.Log;

import com.androidevelopers.cs5540.businessexchange.models.ProfessionalData;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseException;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

/**
 * Created by rohangoel on 8/8/17.
 */

public class QueriesResponsesFireBaseHelper {

    private DatabaseReference db;
    private ArrayList<ProfessionalData> queriesresponses;

    public QueriesResponsesFireBaseHelper(DatabaseReference db, ArrayList<ProfessionalData> queriesresponses) {
        this.db = db;
        this.queriesresponses = queriesresponses;
    }

    public Boolean save(ProfessionalData professionalData)
    {
        Boolean saved;
        if(professionalData==null) {
            saved=false;
        }
        else {
            try {
                db.child(FirebaseUrls.QUERIES_RESPONSES).push().setValue(professionalData);
                saved=true;
            }catch (DatabaseException e) {
                e.printStackTrace();
                saved=false;
            }
        }
        return saved;
    }

    private void fetchData(DataSnapshot dataSnapshot)
    {
        queriesresponses.clear();
        for (DataSnapshot ds : dataSnapshot.getChildren())
        {
            ProfessionalData professionalData=ds.getValue(ProfessionalData.class);
            queriesresponses.add(professionalData);
        }
    }

    public ArrayList<ProfessionalData> retrieveData()
    {
        db.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                fetchData(dataSnapshot);
                Log.i("retrieve method 2:", queriesresponses.get(0).getFirstName());
            }
            @Override
            public void onCancelled(DatabaseError databaseError) {
            }
        });

        return queriesresponses;
    }
}

