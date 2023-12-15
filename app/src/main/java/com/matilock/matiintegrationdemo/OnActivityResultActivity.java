package com.matilock.matiintegrationdemo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.metamap.metamap_sdk.MetamapButton;
import com.metamap.metamap_sdk.MetamapSdk;

public class OnActivityResultActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_metamap_button);

        MetamapButton btn = findViewById(R.id.metamapButton);
        btn.setParams(this, "YOUR_CLIENT_ID", "YOUR_FLOW_ID");
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == MetamapSdk.DEFAULT_REQUEST_CODE) {
            if (resultCode == Activity.RESULT_OK && data != null) {
                // There are no request codes
                Toast.makeText(
                        this,
                        "onActivityResult Verification success! " +
                                "VerificationId:" + data.getStringExtra(MetamapSdk.ARG_VERIFICATION_ID) +
                                "IdentityId: " + data.getStringExtra(MetamapSdk.ARG_IDENTITY_ID),
                        Toast.LENGTH_SHORT
                ).show();
            } else {
                if (data != null) {
                    Toast.makeText(
                            this,
                            "onActivityResult Verification cancelled! " +
                                    "VerificationId:" + data.getStringExtra(MetamapSdk.ARG_VERIFICATION_ID) +
                                    "IdentityId: " + data.getStringExtra(MetamapSdk.ARG_IDENTITY_ID),
                            Toast.LENGTH_SHORT
                    ).show();
                } else {
                    Toast.makeText(
                            this,
                            "onActivityResult Verification cancelled!",
                            Toast.LENGTH_SHORT
                    ).show();
                }
            }
        } else {
            super.onActivityResult(requestCode, resultCode, data);
        }
    }
}