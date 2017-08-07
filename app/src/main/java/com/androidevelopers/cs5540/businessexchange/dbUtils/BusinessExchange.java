package com.androidevelopers.cs5540.businessexchange.dbUtils;

import android.app.Application;
import com.firebase.client.Firebase;
/**
 * Created by rohangoel on 8/2/17.
 */

public class BusinessExchange extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        Firebase.setAndroidContext(this);
    }
}