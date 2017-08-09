package com.androidevelopers.cs5540.businessexchange.activity;

/**
 * Created by Richard on 8/9/17.
 */


        import android.app.ProgressDialog;
        import android.content.Intent;
        import android.support.v7.app.AppCompatActivity;
        import android.os.Bundle;
        import android.text.TextUtils;
        import android.view.View;
        import android.widget.Button;
        import android.widget.EditText;
        import android.widget.TextView;
        import android.widget.Toast;

        import com.androidevelopers.cs5540.businessexchange.R;
        import com.google.android.gms.tasks.OnCompleteListener;
        import com.google.android.gms.tasks.Task;
        import com.google.firebase.auth.AuthResult;
        import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button buttonCreateAccount;
    private EditText editTextEmail;
    private EditText editTextPassword;
    private TextView textViewGoToLogin;
    private ProgressDialog progressDialog;
    private FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        firebaseAuth = FirebaseAuth.getInstance();
        if(firebaseAuth.getCurrentUser() != null) {
            //user is logged in, start user profile activity
            finish();
            startActivity(new Intent(getApplicationContext(), ProfileActivity.class));
        }

        progressDialog = new ProgressDialog (this);

        buttonCreateAccount = (Button) findViewById(R.id.bt_create_account);
        editTextEmail = (EditText) findViewById(R.id.et_create_email);
        editTextPassword = (EditText) findViewById(R.id.et_create_password);
        textViewGoToLogin = (TextView) findViewById(R.id.tv_go_to_login);

        buttonCreateAccount.setOnClickListener(this);
        textViewGoToLogin.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if(v == textViewGoToLogin) {
            startActivity(new Intent(this, LoginActivity.class));
        }

        if(v == buttonCreateAccount) createAccount();
    }

    private void createAccount() {

        String email = editTextEmail.getText().toString().trim();
        String password = editTextPassword.getText().toString().trim();

        if(TextUtils.isEmpty(email)){
            //username field empty
            Toast.makeText(this,"Please enter your email address",Toast.LENGTH_LONG).show();
            return;
        }

        if(TextUtils.isEmpty(password)){
            //password field is empty
            Toast.makeText(this,"Please enter password",Toast.LENGTH_LONG).show();
            return;
        }

        //if fields have entries
        progressDialog.setMessage("Creating a user account...");
        progressDialog.show();

        firebaseAuth.createUserWithEmailAndPassword(email,password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(Task<AuthResult> authResultTask) {
                        progressDialog.dismiss();
                        if(authResultTask.isSuccessful()) {
                            //successful account created
                            //start users profile activity
                            finish();
                            startActivity(new Intent(getApplicationContext(), ProfileActivity.class));
                        }else {
                            Toast.makeText(MainActivity.this, "Failed To Create Account", Toast.LENGTH_LONG).show();
                        }
                    }
                });
    }


}