    package com.androidevelopers.cs5540.businessexchange.activity;

    import android.content.Intent;
    import android.os.Bundle;
    import android.support.v7.app.AppCompatActivity;
    import android.util.Log;
    import android.view.View;
    import android.widget.Button;
    import android.widget.EditText;
    import android.widget.ImageButton;
    import android.widget.TextView;

    import com.androidevelopers.cs5540.businessexchange.adapters.CameraAdapter;
    import com.androidevelopers.cs5540.businessexchange.R;
    import com.androidevelopers.cs5540.businessexchange.dbUtils.DbUrls;
    import com.androidevelopers.cs5540.businessexchange.models.ProfessionalData;
    import com.google.firebase.database.DataSnapshot;
    import com.google.firebase.database.DatabaseError;
    import com.google.firebase.database.DatabaseReference;
    import com.google.firebase.database.FirebaseDatabase;
    import com.google.firebase.database.Query;
    import com.google.firebase.database.ValueEventListener;

    /**
     * Created by rajat on 8/6/2017.
     */

    public class SignUpView extends AppCompatActivity {
        int id;
        private String firstName;
        private String lastName;
        private String profession;
        private String city;
        private String contact;
        private String emailAddress;
        private String street;
        private String state;
        private String zipCode;
        private String imageUrl="";
        private EditText firstNameEditText;
        private EditText lastNameEditText;
        private EditText professionEditText;
        private EditText cityEditText;
        private EditText emailAddressEditText;
        private ImageButton clickImage;
        private EditText contactEditText;
        private Button Signup;
        private EditText streetEditText;
        private EditText stateEditText;
        private EditText zipCodeEditText;
        private TextView textViewFirstName;
        private TextView textViewLastName;
        private TextView textViewProfession;
        private TextView textViewCity;
        private TextView textViewEmailAddress;
        private TextView textViewClickImage;
        private TextView textViewContact;
        private TextView textViewStreet;
        private TextView textViewState;
        private TextView textViewZipCode;
        DatabaseReference db;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);

            //TODO 2 Inserting signup details into database by fetching the max(id) from Database and inserting
            db = FirebaseDatabase.getInstance().getReference(DbUrls.BASE_URL);
            textViewFirstName = (TextView) findViewById(R.id.signup_first_name_text_view);
            textViewLastName = (TextView) findViewById(R.id.signup_last_name_text_view);
            textViewProfession=(TextView) findViewById(R.id.signup_profession_text_view);
            textViewCity =(TextView) findViewById(R.id.signup_city_text_view);
            textViewClickImage =(TextView) findViewById(R.id.signup_image_text_view);
            textViewContact =(TextView) findViewById(R.id.signup_contact_text_view);
            textViewStreet=(TextView) findViewById(R.id.signup_street_text_view);
            textViewEmailAddress =(TextView) findViewById(R.id.signup_email_text_view);
            textViewState=(TextView) findViewById(R.id.signup_state_text_view);
            textViewZipCode=(TextView) findViewById(R.id.signup_zipcode_text_view);
            firstNameEditText = (EditText) findViewById(R.id.sign_up_first_name_edit_text);
            lastNameEditText = (EditText) findViewById(R.id.sign_up_last_name_edit_text);
            professionEditText = (EditText) findViewById(R.id.sign_up_profession_edit_text);
            cityEditText = (EditText) findViewById(R.id.sign_up_city_edit_text);
            emailAddressEditText = (EditText) findViewById(R.id.sign_up_email_edit_text);
            clickImage = (ImageButton) findViewById(R.id.sign_up_take_picture);
            contactEditText = (EditText) findViewById(R.id.sign_up_contact_edit_text);
            Signup = (Button) findViewById(R.id.sign_up_button);
            streetEditText = (EditText) findViewById(R.id.sign_up_street_edit_text);
            stateEditText = (EditText) findViewById(R.id.sign_up_state_edit_text);
            zipCodeEditText = (EditText) findViewById(R.id.signup_zipcode_edit_text);

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

        void openCamera(View view){
            Intent intent= new Intent(this, CameraAdapter.class);
            this.startActivity(intent);
        }

        void addUser(View view){
            firstName = firstNameEditText.getText().toString();
            lastName = lastNameEditText.getText().toString();
            contact = contactEditText.getText().toString();
            profession = professionEditText.getText().toString();
            emailAddress = emailAddressEditText.getText().toString();
            street = streetEditText.getText().toString();
            state = stateEditText.getText().toString();
            city = cityEditText.getText().toString();
            zipCode = streetEditText.getText().toString();
            ProfessionalData professionalData =
                    new ProfessionalData(firstName,lastName,city,contact
                            ,emailAddress,state, street,zipCode,profession,imageUrl,id);

            db.child("professionals-details").setValue(id,professionalData);
            Intent intent = new Intent(this,ProfessionalDashboard.class);
            this.startActivity(intent);
        }

    }
