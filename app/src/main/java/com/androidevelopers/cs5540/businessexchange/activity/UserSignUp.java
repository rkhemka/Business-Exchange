package com.androidevelopers.cs5540.businessexchange.activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.androidevelopers.cs5540.businessexchange.R;
import com.androidevelopers.cs5540.businessexchange.dbUtils.DbUrls;
import com.androidevelopers.cs5540.businessexchange.models.LoginData;
import com.androidevelopers.cs5540.businessexchange.models.ProfessionalData;
import com.androidevelopers.cs5540.businessexchange.models.UserData;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

/**
 * Created by rohangoel on 8/7/17.
 */

public class UserSignUp extends AppCompatActivity{

    int id;
    private String firstName;
    private String lastName;
    private String contact;
    private String emailAddress;
    private String password;
    private EditText firstNameEditText;
    private EditText lastNameEditText;
    private EditText emailAddressEditText;
    private EditText contactEditText;
    private EditText passwordEditText;
    private TextView textViewFirstName;
    private TextView textViewLastName;
    private TextView textViewContact;
    private TextView textViewPassword;
    private TextView textViewEmailAddress;
    private Button Signup;
    DatabaseReference db;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState, @Nullable PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);
        db = FirebaseDatabase.getInstance().getReference(DbUrls.BASE_URL);
        firstNameEditText = (EditText) findViewById(R.id.user_editText_FirstName);
        lastNameEditText = (EditText) findViewById(R.id.user_editText_lastName);
        contactEditText = (EditText) findViewById(R.id.user_editText_phone);
        emailAddressEditText =(EditText) findViewById(R.id.user_editText_email);
        passwordEditText = (EditText) findViewById(R.id.user_editText_password);
        textViewFirstName = (TextView) findViewById(R.id.user_textview_firstName);
        textViewLastName = (TextView) findViewById(R.id.user_textview_lastName);
        textViewContact = (TextView) findViewById(R.id.user_textview_contact);
        textViewEmailAddress = (TextView) findViewById(R.id.user_textview_emailId);
        textViewPassword = (TextView) findViewById(R.id.user_textview_password);
        id = fetchId();

    }

    public int fetchId(){
        int id=-1;
        Query getIdQuery = db.child(DbUrls.PROFESSIONAL_LOGIN_DETAILS).orderByChild("id").limitToLast(1);
        getIdQuery.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                getId(dataSnapshot);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
        return id;
    }

    public int getId(DataSnapshot dataSnapshot){
        int id=-1;
        for (DataSnapshot ds : dataSnapshot.getChildren())
        {
            ProfessionalData professionalData = ds.getValue(ProfessionalData.class);
            id=professionalData.getId();
            Log.i("finally i got id: ----", String.valueOf(id));
        }
        return id++;
    }


    void addUser(View view){
        firstName = firstNameEditText.getText().toString();
        lastName = lastNameEditText.getText().toString();
        contact = contactEditText.getText().toString();
        emailAddress = emailAddressEditText.getText().toString();
        password = passwordEditText.getText().toString();
        UserData userData =
                new UserData(firstName,lastName,contact,emailAddress,id);

        db.child("users-details").setValue(id,userData);

        LoginData loginData = new LoginData(id,emailAddress,password);
        db.child("user-login-details").setValue(id,loginData);


        Intent intent = new Intent(this,UserDashboard.class);
        this.startActivity(intent);
    }

}