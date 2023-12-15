package com.matilock.matiintegrationdemo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import com.metamap.metamap_sdk.MetamapButton;
import com.metamap.metamap_sdk.MetamapSdk;

public class ResultApiActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_metamap_button);

        MetamapButton btn = findViewById(R.id.metamapButton);
        btn.setParams(resultLauncher, this, "YOUR_CLIENT_ID", "YOUR_FLOW_ID");

    }


    /*
     * In case you want to use Activity Result API
     */
    private final ActivityResultLauncher<Intent> resultLauncher = registerForActivityResult(
            new ActivityResultContracts.StartActivityForResult(),
            result -> {
                Intent data = result.getData();
                if (data == null) {
                    Toast.makeText(this, "Verification cancelled", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (result.getResultCode() == Activity.RESULT_OK) {
                    // There are no request codes
                    Toast.makeText(
                            this,
                            "Verification success! " +
                                    "VerificationId:" + data.getStringExtra(MetamapSdk.ARG_VERIFICATION_ID) +
                                    "IdentityId: " + data.getStringExtra(MetamapSdk.ARG_IDENTITY_ID),
                            Toast.LENGTH_SHORT
                    ).show();
                } else {
                    Toast.makeText(
                            this,
                            "Verification cancelled! " +
                                    "VerificationId:" + data.getStringExtra(MetamapSdk.ARG_VERIFICATION_ID) +
                                    "IdentityId: " + data.getStringExtra(MetamapSdk.ARG_IDENTITY_ID),
                            Toast.LENGTH_SHORT
                    ).show();
                }
            });
}