package com.androidevelopers.cs5540.businessexchange;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

import com.androidevelopers.cs5540.businessexchange.activity.LoginOptionView;

public class MainActivity extends AppCompatActivity {

    private ImageView mainScreenImage;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mainScreenImage = (ImageView) findViewById(R.id.main_screen_image);
        mainScreenImage.animate().alpha(1).setDuration(10000);

        Handler handler = new Handler();

        handler.postDelayed(new Runnable() { 
            @Override
            public void run() {
                Intent intent = new Intent(MainActivity.this, LoginOptionView.class);
                startActivity(intent);
            }
        },50000);



    }



//    Inflate in Profession Activity
//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        getMenuInflater().inflate(R.menu.menu, menu);
//
//        MenuItem item = menu.findItem(R.id.categoryMenuItem);
//        Spinner spinner = (Spinner) MenuItemCompat.getActionView(item);
//        spinner.setOnItemSelectedListener(this);
//
//        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
//                R.array.professions,
//                android.R.layout.simple_spinner_item);
//        adapter.setDropDownViewResource(
//                android.R.layout.simple_spinner_dropdown_item);
//
//        spinner.setAdapter(adapter);
//        return true;
//    }
//
//    @Override
//    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
//
//    }
//
//    @Override
//    public void onNothingSelected(AdapterView<?> adapterView) {
//
//    }
}