package com.androidevelopers.cs5540.businessexchange.dbUtils;

import com.androidevelopers.cs5540.businessexchange.models.ProfessionalData;
import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.client.ValueEventListener;
import com.google.firebase.database.DatabaseException;

import java.util.ArrayList;

/**
 * Created by rohangoel on 8/6/17.
 */

public class FirebaseHelper {
    Firebase db;
    Boolean saved;
    ArrayList<ProfessionalData> professionals=new ArrayList<>();
    /*
 PASS DATABASE REFRENCE
  */
    public FirebaseHelper(Firebase db) {
        this.db = db;
    }
    //WRITE IF NOT NULL
    public Boolean save(ProfessionalData professioanal)
    {
        if(professioanal==null)
        {
            saved=false;
        }else
        {
            try
            {
                db.child("professional_details").push().setValue(professioanal);
                saved=true;
            }catch (DatabaseException e)
            {
                e.printStackTrace();
                saved=false;
            }
        }
        return saved;
    }
    //IMPLEMENT FETCH DATA AND FILL ARRAYLIST
    private void fetchProfessionalsData(DataSnapshot dataSnapshot)
    {
        professionals.clear();
        for (DataSnapshot ds : dataSnapshot.getChildren())
        {
            ProfessionalData professional=ds.getValue(ProfessionalData.class);
            professionals.add(professional);
        }
    }
    //RETRIEVE
    public ArrayList<ProfessionalData> retrieve()
    {
        db.addValueEventListener(new ValueEventListener() {

            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                fetchProfessionalsData(dataSnapshot);
            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {

            }
        });
        return professionals;
    }
}

