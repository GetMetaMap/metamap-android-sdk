package com.matilock.matiintegrationdemo;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.getmati.mati_sdk.MatiButton;
import com.getmati.mati_sdk.MatiSdk;
import com.getmati.mati_sdk.Metadata;


public class MainActivity  extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        MatiButton btn = findViewById(R.id.matiKYCButton);

        btn.setParams(this,
                "YOUR_CLIENT_ID",
                "YOUR_FLOW_ID",
                new Metadata.Builder()
                        .with("userId", "qwfguweo")
                        .with("type", 2)
                        .build());
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if(requestCode == MatiSdk.REQUEST_CODE && data!=null) {
            if(resultCode == RESULT_OK) {
                Toast.makeText( this,"SUCCESS | VerificationId: " + data.getStringExtra(MatiSdk.ARG_VERIFICATION_ID)
                        + " IdentityId: " + data.getStringExtra(MatiSdk.ARG_IDENTITY_ID), Toast.LENGTH_LONG).show();
            } else {
                Toast.makeText( this,"CANCELLED | VerificationId: " + data.getStringExtra(MatiSdk.ARG_VERIFICATION_ID)
                        + " IdentityId: " + data.getStringExtra(MatiSdk.ARG_IDENTITY_ID), Toast.LENGTH_LONG).show();
            }
        } else {
            super.onActivityResult(requestCode, resultCode, data);
        }
    }
}