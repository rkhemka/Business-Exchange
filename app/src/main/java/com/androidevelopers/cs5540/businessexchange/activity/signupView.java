    package com.androidevelopers.cs5540.businessexchange.activity;

    import android.Manifest;
    import android.content.Context;
    import android.content.pm.PackageManager;
    import android.graphics.ImageFormat;
    import android.graphics.SurfaceTexture;
    import android.hardware.camera2.CameraAccessException;
    import android.hardware.camera2.CameraCaptureSession;
    import android.hardware.camera2.CameraCharacteristics;
    import android.hardware.camera2.CameraDevice;
    import android.hardware.camera2.CameraManager;
    import android.hardware.camera2.CameraMetadata;
    import android.hardware.camera2.CaptureRequest;
    import android.hardware.camera2.TotalCaptureResult;
    import android.hardware.camera2.params.StreamConfigurationMap;
    import android.media.Image;
    import android.media.ImageReader;
    import android.os.Bundle;
    import android.os.Environment;
    import android.os.Handler;
    import android.os.HandlerThread;
    import android.support.annotation.NonNull;
    import android.support.v4.app.ActivityCompat;
    import android.support.v7.app.AppCompatActivity;
    import android.util.Log;
    import android.util.Size;
    import android.util.SparseIntArray;
    import android.view.Surface;
    import android.view.TextureView;
    import android.view.View;
    import android.widget.Button;
    import android.widget.EditText;
    import android.widget.ImageButton;
    import android.widget.TextView;
    import android.widget.Toast;

    import com.androidevelopers.cs5540.businessexchange.R;

    import java.io.File;
    import java.io.FileNotFoundException;
    import java.io.FileOutputStream;
    import java.io.IOException;
    import java.io.OutputStream;
    import java.nio.ByteBuffer;
    import java.util.ArrayList;
    import java.util.Arrays;
    import java.util.List;

    /**
     * Created by rajat on 8/6/2017.
     */

    public class signupView extends AppCompatActivity {
         private EditText firstName;
        private EditText lastName;
        private EditText profession;
        private EditText city;
        private EditText emailAddress;
        private ImageButton clickMe;
        private EditText contact;
        private Button Signup;
        private EditText street;
        private EditText state;
        private EditText zipCode;

        private TextView textViewFirstName;
        private TextView textViewLastName;
        private TextView textViewProfession;
        private TextView textViewCity;
        private TextView textViewEmailAddress;
        private TextView textViewClickMe;
        private TextView textViewContact;
        private TextView textViewStreet;
        private TextView textViewState;
        private TextView textViewZipCode;




        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);

            //TODO 2 Inserrting signup details into database by fetching the max(id) from Database and inserting
            firstName = (EditText) findViewById(R.id.sign_up_first_Name);
            lastName = (EditText) findViewById(R.id.sign_up_last_Name);
            profession = (EditText) findViewById(R.id.sign_up_profession);
            city = (EditText) findViewById(R.id.sign_up_city);
            emailAddress = (EditText) findViewById(R.id.sign_up_email);
            clickMe = (ImageButton) findViewById(R.id.sign_up_take_picture);
            contact = (EditText) findViewById(R.id.sign_up_contact);
            Signup = (Button) findViewById(R.id.sign_up_button);
            street = (EditText) findViewById(R.id.sign_up_street);
            state = (EditText) findViewById(R.id.sign_up_state);
            zipCode = (EditText) findViewById(R.id.signup_View_ZipCode);

            textViewFirstName = (TextView) findViewById(R.id.textview_firstName);
            textViewLastName = (TextView) findViewById(R.id.textview_lastName);
            textViewProfession=(TextView) findViewById(R.id.textview_profession);
            textViewCity =(TextView) findViewById(R.id.textview_city);
            textViewClickMe=(TextView) findViewById(R.id.textview_picture);
            textViewContact =(TextView) findViewById(R.id.textview_contact);
            textViewStreet=(TextView) findViewById(R.id.textview_street);
            textViewEmailAddress =(TextView) findViewById(R.id.textview_emailId);
            textViewState=(TextView) findViewById(R.id.textview_state);
            textViewZipCode=(TextView) findViewById(R.id.sign_up_my_zip);



        }


    }
