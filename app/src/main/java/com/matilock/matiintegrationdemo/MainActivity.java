package com.matilock.matiintegrationdemo;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.methodCall).setOnClickListener(listener);
        findViewById(R.id.metamapButton).setOnClickListener(listener);
        findViewById(R.id.metadata).setOnClickListener(listener);
        findViewById(R.id.onActivityResult).setOnClickListener(listener);
        findViewById(R.id.resultApi).setOnClickListener(listener);
        findViewById(R.id.colorsCustomization).setOnClickListener(listener);
        findViewById(R.id.fontCustomization).setOnClickListener(listener);
        findViewById(R.id.facematch).setOnClickListener(listener);
        findViewById(R.id.cooldown).setOnClickListener(listener);
        findViewById(R.id.onDemandConfig).setOnClickListener(listener);
        findViewById(R.id.encryptionConfig).setOnClickListener(listener);
        findViewById(R.id.smartCapture).setOnClickListener(listener);
    }

    private final View.OnClickListener listener = v -> {
        Intent intent;
        switch (v.getId()) {
            case R.id.methodCall:
                intent = new Intent(MainActivity.this, MethodCallActivity.class);
                startActivity(intent);
                break;
            case R.id.metamapButton:
                intent = new Intent(MainActivity.this, MetamapButtonActivity.class);
                startActivity(intent);
                break;
            case R.id.metadata:
                intent = new Intent(MainActivity.this, MetadataActivity.class);
                startActivity(intent);
                break;
            case R.id.onActivityResult:
                intent = new Intent(MainActivity.this, OnActivityResultActivity.class);
                startActivity(intent);
                break;
            case R.id.resultApi:
                intent = new Intent(MainActivity.this, ResultApiActivity.class);
                startActivity(intent);
                break;
            case R.id.colorsCustomization:
                intent = new Intent(MainActivity.this, ColorsCustomizationActivity.class);
                startActivity(intent);
                break;
            case R.id.fontCustomization:
                intent = new Intent(MainActivity.this, FontCustomizationActivity.class);
                startActivity(intent);
                break;
            case R.id.facematch:
                intent = new Intent(MainActivity.this, FaceMatchActivity.class);
                startActivity(intent);
                break;
            case R.id.cooldown:
                intent = new Intent(MainActivity.this, CooldownActivity.class);
                startActivity(intent);
                break;
            case R.id.onDemandConfig:
                intent = new Intent(MainActivity.this, OnDemandConfigActivity.class);
                startActivity(intent);
                break;
            case R.id.encryptionConfig:
                intent = new Intent(MainActivity.this, EncryptionConfigActivity.class);
                startActivity(intent);
                break;
            case R.id.smartCapture:
                intent = new Intent(MainActivity.this, SmartCaptureActivity.class);
                startActivity(intent);
                break;
        }
    };
}