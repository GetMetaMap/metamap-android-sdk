package com.matilock.matiintegrationdemo;

import android.app.Application;

import com.matilock.mati_kyc_sdk.Mati;

public class App extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        Mati.init(this, getString(R.string.client_id));

    }
}
