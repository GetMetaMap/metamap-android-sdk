package com.matilock.matiintegrationdemo;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import com.metamap.metamap_sdk.Metadata;
import com.metamap.metamap_sdk.MetamapButton;
import com.metamap.metamap_sdk.metadata.UIConfig;

public class ColorsCustomizationActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_metamap_button);

        MetamapButton btn = findViewById(R.id.metamapButton);

        int accentColor = ContextCompat.getColor(this, R.color.colorAccent);
        int titleTextColor = ContextCompat.getColor(this, R.color.titleTextColor);
        int subtitleTextColor = ContextCompat.getColor(this, R.color.subtitleTextColor);
        int backgroundColor = ContextCompat.getColor(this, R.color.backgroundColor);
        int lineColor = ContextCompat.getColor(this, R.color.lineColor);

        UIConfig uiConfig = new UIConfig.Builder()
                .accentColor(accentColor)
                .titleTextColor(titleTextColor)  //These colors are used in the loading screen,
                .subtitleTextColor(subtitleTextColor)
                .backgroundColor(backgroundColor)
                .lineColor(lineColor)
                .build();
        Metadata metadata = new Metadata.Builder()
                .uiConfig(uiConfig)
                .build();
        btn.setParams(this, "YOUR_CLIENT_ID", "YOUR_FLOW_ID", metadata);
    }
}