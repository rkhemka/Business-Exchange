package com.androidevelopers.cs5540.businessexchange.dbUtils;

import com.androidevelopers.cs5540.businessexchange.models.LoginData;
import com.androidevelopers.cs5540.businessexchange.models.ProfessionalData;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseException;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.ValueEventListener;
import java.util.ArrayList;

/**
 * Created by rohangoel on 8/6/17.
 */

public class FirebaseHelper {

    DatabaseReference db;
    Boolean saved;
    ArrayList<LoginData> loginList;
    /*
 PASS DATABASE REFERENCE
  */
    public FirebaseHelper(DatabaseReference db)
    {

        this.db = db;
    }

    //WRITE IF NOT NULL

    public Boolean save(ProfessionalData professional)
    {
        if(professional==null) {
            saved=false;
        }
        else {
            try {
                db.child("professional_details").push().setValue(professional);
                saved=true;
            }catch (DatabaseException e) {
                e.printStackTrace();
                saved=false;
            }
        }
        return saved;
    }

    //IMPLEMENT FETCH DATA AND FILL ARRAY LIST

    private void fetchLoginData(DataSnapshot dataSnapshot)
    {
        loginList.clear();
        for (DataSnapshot ds : dataSnapshot.getChildren())
        {
            LoginData credential=ds.getValue(LoginData.class);
            loginList.add(credential);
        }
    }
    //RETRIEVE

    public ArrayList<LoginData> retrieveLoginList()
    {
        db.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                fetchLoginData(dataSnapshot);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
        return loginList;
    }

}