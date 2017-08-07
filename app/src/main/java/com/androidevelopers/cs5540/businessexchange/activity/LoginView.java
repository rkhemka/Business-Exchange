package com.androidevelopers.cs5540.businessexchange.activity;

import android.content.Intent;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.support.annotation.Nullable;
import android.support.v4.app.LoaderManager;
import android.support.v4.content.AsyncTaskLoader;
import android.support.v4.content.Loader;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.androidevelopers.cs5540.businessexchange.R;
import com.androidevelopers.cs5540.businessexchange.dbUtils.DbUrls;
import com.androidevelopers.cs5540.businessexchange.dbUtils.FirebaseHelper;
import com.androidevelopers.cs5540.businessexchange.models.LoginData;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

/**
 * Created by rajat on 8/6/2017.
 */

public class LoginView extends AppCompatActivity implements LoaderManager.LoaderCallbacks<Void>{

    private DatabaseReference mRef;
    private FirebaseHelper loginFirebaseHelper;
    private TextView loginMessageTextView;
    private ImageView appLogoImageView;
    private TextView businessExchangeTextView;
    private EditText usernameEditText;
    private EditText passwordEditText;
    private Button loginButton;
    private ProgressBar progressBar;
    private ArrayList<LoginData> loginList;
    private Boolean isLoginSuccessful=false;
    private int userId;
    private int selectedId;
    private String username;
    private String password;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        loginMessageTextView =(TextView) findViewById(R.id.login_screen_textview);
        businessExchangeTextView = (TextView) findViewById(R.id.business_exchange_textView);
        appLogoImageView =(ImageView) findViewById(R.id.app_logo_image_view);
        usernameEditText = (EditText) findViewById(R.id.login_view_editText_UserName);
        passwordEditText = (EditText) findViewById(R.id.login_view_editText_Password);
        progressBar = (ProgressBar) findViewById(R.id.login_progress_bar);
        loginButton =(Button) findViewById(R.id.login_view_button_login);
        selectedId = getIntent().getIntExtra("selectedId",-1);
        if(selectedId==1)
        mRef =  FirebaseDatabase.getInstance().getReference(DbUrls.BASE_URL+DbUrls.USER_LOGIN_DETAILS);
        else
            mRef = FirebaseDatabase.getInstance().getReference(DbUrls.BASE_URL+DbUrls.PROFESSIONAL_LOGIN_DETAILS);

        loginFirebaseHelper = new FirebaseHelper(mRef);
    }

    @Override
    public Loader<Void> onCreateLoader(int id, final Bundle args) {
        return new AsyncTaskLoader<Void>(this) {

            @Override
            protected void onStartLoading() {
                super.onStartLoading();
                progressBar.setVisibility(View.VISIBLE);
            }
            @Override
            public Void loadInBackground() {
                loginList=loginFirebaseHelper.retrieveLoginList();
                return null;
            }
        };
    }

    @Override
    public void onLoadFinished(Loader<Void> loader, Void data) {
        username = usernameEditText.getText().toString();
        password = passwordEditText.getText().toString();
        for (LoginData credentials: loginList) {
            if(username.equals(credentials.getUserName()))
                if (password.equals(credentials.getPassWord())) {
                    isLoginSuccessful=true;
                    userId=credentials.getId();
                }

        }
        loginCheck(isLoginSuccessful);
    }

    @Override
    public void onLoaderReset(Loader<Void> loader) {

    }
    void loginCheck(Boolean isLoginSuccessful) {

        if(!isLoginSuccessful)
            Toast.makeText(this, "username / password mismatch", Toast.LENGTH_SHORT).show();
        else if(selectedId==0) {
            Intent intent = new Intent(this, ProfessionalDashboard.class);
            intent.putExtra("userId",userId);
            this.startActivity(intent);
        }
        else if(selectedId==1){
            Intent intent = new Intent(this, UserDashboard.class);
            intent.putExtra("userId",userId);
            this.startActivity(intent);
        }
    }
    public void signUp(View view){
        Intent intent = new Intent(this, SignUpView.class);
        this.startActivity(intent);
    }
}
