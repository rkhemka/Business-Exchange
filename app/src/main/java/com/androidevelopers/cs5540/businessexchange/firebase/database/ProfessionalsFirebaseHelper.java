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

public class ProfessionalsFirebaseHelper {

    private DatabaseReference db;
    private ArrayList<ProfessionalData> professionals;

    public ProfessionalsFirebaseHelper(DatabaseReference db, ArrayList<ProfessionalData> professionals) {
        this.db = db;
        this.professionals = professionals;
    }

    public Boolean saveData(ProfessionalData professionalData)
    {
        Boolean saved;
        if(professionalData==null) {
            saved=false;
        }
        else {
            try {
                db.child(FirebaseUrls.PROFESSIONAL_DETAILS).push().setValue(professionalData);
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
        professionals.clear();
        for (DataSnapshot ds : dataSnapshot.getChildren())
        {
            ProfessionalData professionalData=ds.getValue(ProfessionalData.class);
            professionals.add(professionalData);
        }
    }

    public void retrieveData() {
        db.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                fetchData(dataSnapshot);
                retrieve(professionals);
                Log.i("retrieve method : ", professionals.get(0).getFirstName());
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
            }
        });
    }

    public ArrayList<ProfessionalData> retrieve(ArrayList<ProfessionalData> professionals){
        return professionals;
    }

}
