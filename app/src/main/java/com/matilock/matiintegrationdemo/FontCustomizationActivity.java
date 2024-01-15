package com.matilock.matiintegrationdemo;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.metamap.metamap_sdk.Metadata;
import com.metamap.metamap_sdk.MetamapButton;
import com.metamap.metamap_sdk.metadata.FontConfig;
import com.metamap.metamap_sdk.metadata.UIConfig;

public class FontCustomizationActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_metamap_button);

        MetamapButton btn = findViewById(R.id.metamapButton);

        FontConfig fontConfig= new FontConfig(
                "comic_neue.ttf",
                "comic_neue_bold.ttf"
        );
        UIConfig uiConfig = new UIConfig.Builder()
                .fontConfig(fontConfig)
                .build();
        Metadata metadata = new Metadata.Builder()
                .uiConfig(uiConfig)
                .build();
        btn.setParams(this, "YOUR_CLIENT_ID", "YOUR_FLOW_ID", metadata);
        btn.setParams(
                this,
                "YOUR_CLIENT_ID",
                "YOUR_FLOW_ID",
                metadata
        );

    }
}