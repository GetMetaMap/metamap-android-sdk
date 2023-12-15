package com.matilock.matiintegrationdemo;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.metamap.metamap_sdk.MetamapButton;
import com.metamap.metamap_sdk.MetamapSdk;

public class OnDemandConfigActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_metamap_button);

        MetamapButton btn = findViewById(R.id.metamapButton);

        btn.setParams(this, "YOUR_CLIENT_ID", "YOUR_FLOW_ID", null,
                MetamapSdk.DEFAULT_REQUEST_CODE, "YOUR_CONFIGURATION_ID");

    }
}
