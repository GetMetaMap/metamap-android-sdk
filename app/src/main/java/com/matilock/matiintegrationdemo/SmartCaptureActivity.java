package com.matilock.matiintegrationdemo;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.metamap.metamap_sdk.MetamapButton;
import com.metamap.metamap_sdk.MetamapSdk;

/**
 * Once the smart capture dependency is added it will automatically be enabled.
 * However, if you want to enable/disable it manually, please use the following methods
 * Enable the Smart Capture: MetamapSdk.INSTANCE.enableSmartCapture()
 * Disable the Smart Capture: MetamapSdk.INSTANCE.disableSmartCapture()
 */
public class SmartCaptureActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_metamap_button);

        MetamapButton btn = findViewById(R.id.metamapButton);
        btn.setParams(this, "YOUR_CLIENT_ID", "YOUR_FLOW_ID");
    }
}