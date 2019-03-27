package com.matilock.matiintegrationdemo;

import android.content.Intent;
import android.os.Bundle;

import com.matilock.mati_kyc_sdk.LoginError;
import com.matilock.mati_kyc_sdk.LoginResult;
import com.matilock.mati_kyc_sdk.Mati;
import com.matilock.mati_kyc_sdk.MatiCallback;
import com.matilock.mati_kyc_sdk.MatiCallbackManager;
import com.matilock.mati_kyc_sdk.MatiLoginManager;
import com.matilock.mati_kyc_sdk.utils.Util;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity  extends AppCompatActivity implements MatiCallback {

    private MatiCallbackManager mCallbackManager = MatiCallbackManager.createNew();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        MatiLoginManager.getInstance().registerCallback(mCallbackManager, this);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        mCallbackManager.onActivityResult(requestCode, resultCode, data);
        super.onActivityResult(requestCode, resultCode, data);
    }

    @Override
    public void onSuccess(LoginResult pLoginResult) {
        if (pLoginResult.isSuccess()) {
            Util.showShortMessage(MainActivity.this, "Successfully logged in!");
            Mati.getInstance().setIdentityId(pLoginResult.getIdentityId());
        }
    }

    @Override
    public void onCancel() {
        Util.showShortMessage(MainActivity.this, "Cancelled");
    }

    @Override
    public void onError(LoginError pLoginError) {
        Util.showSmthWrongMessage(MainActivity.this);
    }
}