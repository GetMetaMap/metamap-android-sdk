package com.matilock.matiintegrationdemo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import com.metamap.metamap_sdk.Metadata;
import com.metamap.metamap_sdk.MetamapButton;
import com.metamap.metamap_sdk.MetamapSdk;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        MetamapButton btn = findViewById(R.id.matiKYCButton);

        btn.setParams(
                this,
                "YOUR_CLIENT_ID",
                "YOUR_FLOW_ID",
                new Metadata.Builder()
                        .with("userId", "qwfguweo")
                        .with("type", 2)
                        .build());

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == MetamapSdk.DEFAULT_REQUEST_CODE) {
            if (resultCode == Activity.RESULT_OK && data != null) {
                // There are no request codes
                Toast.makeText(
                        this,
                        "onActivityResult Verification success! " +
                                "VerificationId: ${data.getStringExtra(MetamapSdk.ARG_VERIFICATION_ID)}, " +
                                "IdentityId: ${data.getStringExtra(MetamapSdk.ARG_IDENTITY_ID)}",
                        Toast.LENGTH_SHORT
                ).show();
            } else {
                if (data != null) {
                    Toast.makeText(
                            this,
                            "onActivityResult Verification cancelled! " +
                                    "VerificationId: ${data.getStringExtra(MetamapSdk.ARG_VERIFICATION_ID)}, " +
                                    "IdentityId: ${data.getStringExtra(MetamapSdk.ARG_IDENTITY_ID)}",
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

    /*
     * In case you want to use Activity Result API
     */
//    ActivityResultLauncher<Intent> resultLauncher = registerForActivityResult(
//            new ActivityResultContracts.StartActivityForResult(),
//            result -> {
//                Intent data = result.getData();
//                if (data == null) {
//                    Toast.makeText(MainActivity.this, "Verification cancelled", Toast.LENGTH_SHORT).show();
//                    return;
//                }
//                if (result.getResultCode() == Activity.RESULT_OK) {
//                    // There are no request codes
//                    Toast.makeText(
//                            MainActivity.this,
//                            "Verification success! " +
//                                    "VerificationId:" + data.getStringExtra(MetamapSdk.ARG_VERIFICATION_ID) +
//                                    "IdentityId: " + data.getStringExtra(MetamapSdk.ARG_IDENTITY_ID),
//                            Toast.LENGTH_SHORT
//                    ).show();
//                } else {
//                    Toast.makeText(
//                            MainActivity.this,
//                            "Verification cancelled! " +
//                                    "VerificationId:" + data.getStringExtra(MetamapSdk.ARG_VERIFICATION_ID) +
//                                    "IdentityId: " + data.getStringExtra(MetamapSdk.ARG_IDENTITY_ID),
//                            Toast.LENGTH_SHORT
//                    ).show();
//                }
//            });
}