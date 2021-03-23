package com.matilock.matiintegrationdemo;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.getmati.mati_sdk.MatiButton;
import com.getmati.mati_sdk.Metadata;
import com.getmati.mati_sdk.kyc.KYCActivity;


public class MainActivity  extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        MatiButton btn = findViewById(R.id.matiKYCButton);

        btn.setParams("YOUR_CLIENT_ID",
                "YOUR_FLOW_ID",
                new Metadata.Builder()
                        .with("userId", "qwfguweo")
                        .with("type", 2)
                        .build());
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if(requestCode == KYCActivity.REQUEST_CODE) {
            if(resultCode == RESULT_OK) {
              //  Toast.makeText( this,"SUCCESS | VerificationId: " + data.getStringExtra(KYCActivity.ARG_VERIFICATION_ID), Toast.LENGTH_LONG).show();
            } else {
               // Toast.makeText( this,"CANCELLED | VerificationId: " + data.getStringExtra(KYCActivity.ARG_VERIFICATION_ID), Toast.LENGTH_LONG).show();
            }
        } else {
            super.onActivityResult(requestCode, resultCode, data);
        }
    }

}