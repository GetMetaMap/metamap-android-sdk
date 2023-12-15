package com.matilock.matiintegrationdemo;

import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.metamap.metamap_sdk.Metadata;
import com.metamap.metamap_sdk.MetamapSdk;

public class MethodCallActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_simple_button);

        Button btn = findViewById(R.id.metamapButton);
        btn.setOnClickListener(v -> {
            MetamapSdk.INSTANCE.startFlow(
                    this,
                    "YOUR_CLIENT_ID",
                    "YOUR_FLOW_ID",
                    new Metadata.Builder()
                            .additionalData("userId", "qwfguweo")
                            .additionalData("type", 2)
                            .build()
            );
        });
    }
}